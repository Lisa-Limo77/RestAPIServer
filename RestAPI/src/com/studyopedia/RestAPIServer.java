package com.studyopedia;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class RestAPIServer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//Creating the HTTP server on port 8080
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
		
		//Adding paths for client(s), defining API End points
		server.createContext("/api/client1", new Client1Handler());
		server.createContext("/api/client2", new Client2Handler());
		
		//server.setExecutor(null);
		server.start();
		System.out.println("Server started on port 8080");
	}
	static class Client1Handler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String response = "Response from Client 1";
			
			exchange.sendResponseHeaders(200, response.getBytes().length);
			
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
	static class Client2Handler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String response = "Response from Client 2";
			
			exchange.sendResponseHeaders(200, response.getBytes().length);
			
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

}
