package com.stackroute.codeexecutorengine.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
@Service
public class FetchServiceImpl implements FetchService {
    public void fetchFilesAndSave() throws IOException {

//            String[] cmdScript = new String[]{"/bin/bash", "path/to/myScript.sh"};
//
//            Process procScript = Runtime.getRuntime().exec(cmdScript);


        Process p;
        try {
            String[] cmd = {"sh", "/home/user/code-executor-engine/src/main/java/com/stackroute/codeexecutorengine/script/fetch.sh"};
            p = Runtime.getRuntime().exec(cmd);
            System.out.println("Process is:"+p);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

//    @Override
//    public Boolean invoke(File file, VirtualChannel channel){
//        try{
//            Git git = Git.cloneRepository()
//                    .setURI(url)
//                    .setDirectory(localDir)
//                    .setTransportConfigCallback(getTransportConfigCallback())
//                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password))
//                    .call();
//
//            // Default branch to checkout is master
//            if(branch==null || branch.isEmpty()){
//                branch = "master";
//            } else if (cloneType.equals("branch")){
//                branch = "origin" + File.separator + branch;
//            }
//            git.checkout().setName(branch).call();
//            git.close();
//        }catch(GitAPIException e){
//            status = false;
//            e.printStackTrace(listener.getLogger());
//        }
//        return status;
//    }

}
