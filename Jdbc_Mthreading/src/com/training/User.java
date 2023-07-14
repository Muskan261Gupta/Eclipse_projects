package com.training;


class User extends Thread {
//	static BookSeats b;
//	int seats;
//	int total=0;
//	public void run() {
//		System.out.println(Thread.interrupted());
//		System.out.println(Thread.currentThread().isAlive());
//		try {
//			System.out.println(Thread.currentThread().getName());
//			Thread.sleep(5000);
//		} 
//		catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		Thread.yield();
//		Thread.currentThread().setName("Muskan Child");
//		System.out.println(Thread.currentThread().getName());
		
//		b.book(seats);
		
		
//	}

	public static void main(String[] args) throws InterruptedException{

//		Thread.currentThread().setName("Muskan");
//		System.out.println(Thread.currentThread().getName());
//		User u=new User();
//		u.setName("Phla Thread");
//		u.start();
//		u.interrupt();
		
//		u.join();
//		Thread.yield();
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName());
//		User u1=new User();
//		u1.start();
//		
//		b=new BookSeats();
//		User b1=new User();
//		b1.seats=7;
//		b1.start();
//		
//		User b2=new User();
//		b2.seats=6;
//		b2.start();
		
//		User b3=new User();
//		b3.seats=4;
//		b3.start();
		
		BookSeats u=new BookSeats();
		u.start();
//		u.join();
		synchronized (u) {		
			u.wait();
		}
//		u.wait();
		System.out.println("Total : "+u.total);
		
	}

}


class BookSeats extends Thread{
//	public int seats;
//	static int Total_seats=10;
//	static synchronized void book(int seats) {
//		if(Total_seats>=seats) {
//			System.out.println(seats+": Seats Booked successfully");
//			Total_seats=Total_seats-seats;
//			System.out.println("Seats left :"+Total_seats);
//
//		}
//		else {
//			System.out.println("Seats cannot be booked");
//			System.out.println("Seats left :"+Total_seats);
//
//		}
//	}
	int total;
	public void run() {
		
		synchronized (this) {			
			for(int i=1;i<=10;i++) {
				total=total+100;
			}
			this.notify();
		}
	}
	
	
	
}

