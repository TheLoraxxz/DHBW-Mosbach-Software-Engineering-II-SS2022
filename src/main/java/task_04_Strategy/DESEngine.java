package task_04_Strategy;

import java.util.Arrays;

public class DESEngine implements IDESEngine{
    private final KeySchedule keySchedule;
    private final InitialPermutation initialPermutation;
    private final FeistelNetwork feistelNetwork;
    private final IPInverse ipInverse;

    public DESEngine() {
        keySchedule = new KeySchedule();
        initialPermutation = new InitialPermutation();
        feistelNetwork = new FeistelNetwork();
        ipInverse = new IPInverse();
    }

    public String encrypt(String string, String key) {

        String[] subKeys = keySchedule.generateSubKeysForEncryption(key);

        String initialPermutationOutput = initialPermutation.permute(string);

        String feistelNetworkResult = feistelNetwork.iterate(initialPermutationOutput, subKeys);

        return ipInverse.permute(feistelNetworkResult);
    }

    public String decrypt(String string, String key) {

        String[] subKeys = keySchedule.generateSubKeysForDecryption(key);

        String initialPermutationOutput = initialPermutation.permute(string);

        String feistelNetworkResult = feistelNetwork.iterate(initialPermutationOutput, subKeys);

        return ipInverse.permute(feistelNetworkResult);
    }
}
