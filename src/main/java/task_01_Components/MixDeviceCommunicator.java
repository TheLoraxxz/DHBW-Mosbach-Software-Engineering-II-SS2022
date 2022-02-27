package task_01_Components;

import ExtinguishDevices.FoamTank;
import ExtinguishDevices.WaterTank;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class MixDeviceCommunicator {
    private Object mixDevice;
    public MixDeviceCommunicator(WaterTank water, FoamTank foam) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Java\\jdk-17.0.1\\bin\\jarsigner", "-verify", "jar/Configuration.jar");
            Process process = processBuilder.start();
            process.waitFor();

            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            boolean isComponentAccepted = false;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("verified")) {
                    isComponentAccepted = true;
                }
            }
            if (!isComponentAccepted){
                throw new RuntimeException();
            }
            URL[] urls = {new File("jar\\Configuration.jar").toURI().toURL()};
            URLClassLoader load = new URLClassLoader(urls,MixDeviceCommunicator.class.getClassLoader());

            Class mixDevice = Class.forName("MixDevice",true,load);
            Object[] inputParameters = new Object[]{water, foam};
            this.mixDevice = mixDevice.getConstructor().newInstance(inputParameters);

        } catch (IOException | InterruptedException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
    public void defill(int amount) {
        try {
            Method method = mixDevice.getClass().getDeclaredMethod("defill",Integer.class);
            method.invoke(method, amount);
        } catch (NoSuchMethodException ne) {
            throw new RuntimeException();
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setToNextMix() {
        try {
            Method method = mixDevice.getClass().getDeclaredMethod("setToNextMix");
            method.invoke(method);
        } catch (NoSuchMethodException ne) {
            throw new RuntimeException();
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public WaterTank getWaterTank() {
        try {
            Method method = mixDevice.getClass().getDeclaredMethod("getWaterTank");
            Object returnValue =method.invoke(method);
            return (WaterTank) returnValue;
        } catch (NoSuchMethodException ne) {
            throw new RuntimeException();
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public FoamTank getFoamTank() {
        try {
            Method method = mixDevice.getClass().getDeclaredMethod("getFoamTank");
            Object returnValue =method.invoke(method);
            return (FoamTank) returnValue;
        } catch (NoSuchMethodException ne) {
            throw new RuntimeException();
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
