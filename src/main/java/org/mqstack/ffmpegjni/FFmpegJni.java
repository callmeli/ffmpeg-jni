package org.mqstack.ffmpegjni;

/**
 * Created by mqstack on 2015/11/23.
 */
public class FFmpegJni {
    static  FFmpegJni mInstance;
    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpegjni");
    }
    public static FFmpegJni getInstance(){
        if(mInstance==null){
            synchronized (FFmpegJni.class){
                if(mInstance==null){
                    mInstance = new FFmpegJni();
                }
            }
        }
        return mInstance;
    }

    public int ffmpegRunCommand(String command) {
        if (command.isEmpty()) {
            return -1;
        }
        String[] args = command.split(" ");
//        for (int i = 0; i < args.length; i++) {
//            Log.d("ffmpeg-jni", args[i]);
//        }
        return run(args.length, args);
    }

    public native int run(int argc, String[] args);
}