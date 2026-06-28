package com.example.demo.controller;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleClient {
	
	private static final Logger log = LogManager.getLogger(SimpleClient.class);
	
    public static void main(String[] args) {
    	
    	try {
			InetAddress local = InetAddress.getLocalHost();
			
			log.info(local.getHostAddress() );
			
			String serverIp = local.getHostAddress(); // 로컬 IP 주소
	        int serverPort = 5000;         // 서버와 동일한 포트 번호
	        
	        try (Socket socket = new Socket(serverIp, serverPort)) {
	            System.out.println("[Client] 서버에 연결 성공!");
	            
	            // 서버로 데이터를 보낼 스트림 생성
	            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
	            
	            // 메시지 전송 (끝에 \n을 포함하기 위해 println 사용)
	            writer.println("안녕하세요, STS에서 보낸 소켓 메시지입니다.");
	            System.out.println("[Client] 메시지를 전송했습니다.");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
        
    }
}
