package task_04_Strategy;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RSAEngine implements IRSAEngine{
    private final BigInteger n;
    private final BigInteger phiN;
    private BigInteger p;
    private BigInteger q;
    private BigInteger e;
    private BigInteger d;

    public RSAEngine(int keySize) {
        if (keySize < 512) {
            throw new IllegalArgumentException("key size too small");
        }

        SecureRandom randomGenerator = new SecureRandom();
        generatePQ(keySize / 2, randomGenerator);
        n = p.multiply(q);
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        generateExponents(invertibleSet());
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getPhiN() {
        return phiN;
    }

    public BigInteger getModulus() {
        return n;
    }

    public BigInteger getPublicKeyExponent() {
        return e;
    }

    public BigInteger getPrivateKeyExponent() {
        return d;
    }

    public String encrypt(String plainMessage) {
        BigInteger plainMessageEncoded = new BigInteger(plainMessage.getBytes());
        byte[] cipher = plainMessageEncoded.modPow(e, n).toByteArray();
        return convertToHex(cipher);
    }

    public String decrypt(String cipher) {
        BigInteger cipherEncoded = new BigInteger(cipher, 16);
        return new String(cipherEncoded.modPow(d, n).toByteArray());
    }

    private void generatePQ(int bitLength, Random randomGenerator) {
        while (true) {
            p = generateOddPrime(bitLength, randomGenerator);
            q = generateOddPrime(bitLength, randomGenerator);
            if (!p.equals(q)) {
                return;
            }
        }
    }

    private BigInteger generateOddPrime(int bitLength, Random randomGenerator) {
        BigInteger two = new BigInteger("2");
        while (true) {
            BigInteger prime = BigInteger.probablePrime(bitLength, randomGenerator);
            if (!prime.mod(two).equals(BigInteger.ZERO)) {
                return prime;
            }
        }
    }

    private void generateExponents(BigInteger[] invertibleSet) {
        Random randomGenerator = new Random();
        while (true) {
            BigInteger invertible = invertibleSet[randomGenerator.nextInt(invertibleSet.length)];
            BigInteger inverse = invertible.modInverse(phiN);
            if (invertible.multiply(inverse).mod(phiN).equals(BigInteger.ONE.mod(phiN))) {
                e = invertible;
                d = inverse;
                return;
            }
        }
    }

    private BigInteger[] invertibleSet() {
        final int maxSize = 100000;
        Set<BigInteger> invertibleSet = new HashSet<>();
        BigInteger end = n.subtract(BigInteger.ONE);

        for (BigInteger i = new BigInteger("5"); i.compareTo(end) < 0; i = i.add(BigInteger.ONE)) {
            if (i.gcd(phiN).equals(BigInteger.ONE)) {
                invertibleSet.add(i);
                if (invertibleSet.size() == maxSize) {
                    break;
                }
            }
        }

        return invertibleSet.toArray(new BigInteger[0]);
    }

    private String convertToHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
