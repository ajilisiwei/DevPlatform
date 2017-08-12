package com.ajilisiwei.devplatform.helper;

import java.io.*;

/**
 * Created by WEI on 12/08/2017.
 */
public class ShellHelper {

    public static void ExecShellScriptFile(String filepath){
        if (filepath==null||"".equals(filepath)){
            return;
        }
        File file=new File(filepath);
        if (!file.exists()){
            return;
        }
        ExecCmd(filepath);
    }

    public static void ExecShellCmd(String cmdStr){
        if (cmdStr==null||"".equals(cmdStr)){
            return;
        }
        ExecCmd(cmdStr);

    }

    private static void ExecCmd(String cmdStr){
        try {
            Process process=Runtime.getRuntime().exec(cmdStr);
            InputStream inputStream=process.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            inputStreamReader.close();
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
