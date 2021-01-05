/*
package cn.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

	public static void main(String[] args) throws Exception {

		//创建一个线程池,每连接到一个客户端，就启动一个线程和客户端进行通信
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

		@SuppressWarnings("resource")
		ServerSocket server=new ServerSocket(6666);
		System.out.println("tomcat服务器启动...");
		while(true){
			System.out.println("线程信息id=" + Thread.currentThread().getId() + "名字=" + Thread.currentThread().getName());
			//阻塞， 等待客户端连接
			System.out.println("等待连接");
			final Socket socket = server.accept();
			System.out.println("连接到一个客户端！");
			newCachedThreadPool.execute(new Runnable() {

				@Override
				public void run() {
					//业务处理
					handler(socket);
				}
			});
		}

	}

	*/
/**
	 * 处理
	 * @param socket
	 *//*

	public static void handler(Socket socket){
			try {
				System.out.println("线程信息id=" + Thread.currentThread().getId() + "名字=" + Thread.currentThread().getName());
				byte[] bytes = new byte[1024];
				InputStream inputStream = socket.getInputStream();

				while(true){
					//读客户端数据 阻塞
					System.out.println("线程信息id=" + Thread.currentThread().getId() + "名字=" + Thread.currentThread().getName());
					System.out.println("read...");
					int read = inputStream.read(bytes);
					if(read != -1){
						System.out.println(new String(bytes, 0, read));
					}else{
						break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					System.out.println("关闭和client的连接..");
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

}
*/
