package cn.test.jvm.gc;

public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        /*long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机中的内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();//返回Java虚拟机试图使用的最大内存量
        System.out.println("TOTAL_MEMORY(-Xms)=" + totalMemory + "(字节)、" + (totalMemory / (double) 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx)=" + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");*/
        System.out.println("*********hello GC");
//        byte[] byteArray = new byte[50 * 1024 * 1024];
        //new 一个大对象直接撑爆了堆空间，在分配内存的过程中不得不产生垃圾回收
        Thread.sleep(Integer.MAX_VALUE);


    }
}
