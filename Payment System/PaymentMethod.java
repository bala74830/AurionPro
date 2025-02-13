package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.CreditCardPaymnt;
import com.aurionpro.model.DebitCardPayment;
import com.aurionpro.model.UpiPayment;

public class PaymentMethod {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int pendingAmount;
		
		
		while(true)
		{
			System.out.println("Enter the amount you have to pay: ");
			pendingAmount = sc.nextInt();
			
			if(pendingAmount < 0 ) {
				System.out.println("Enter valid amount: ");
			}
			else {
				break;
			}
		}
		
		System.out.println("Available payment method : ");
		System.out.println("1.Credit Card : ");
		System.out.println("2.Debit card : ");
		System.out.println("3.upi : ");
		
		int choice;
		
		boolean flag = false;
		
		while(!flag)
		{
			System.out.println("Enter your choice : ");
		    choice = sc.nextInt();
		    
			switch(choice)
			{
			case 1 : CreditCardPaymnt creditCard = new CreditCardPaymnt();
					 System.out.println("total amount payable is : Rs"+creditCard.processPayment(pendingAmount));
					 flag = true;
					 break;
					 
			case 2 : DebitCardPayment debitCard = new DebitCardPayment();
					 System.out.println("total amount payable is : Rs"+debitCard.processPayment(pendingAmount));
					 flag = true;
					 break;
			 
			case 3 : UpiPayment upi = new UpiPayment();
			         System.out.println("total amount payable is : Rs"+upi.processPayment(pendingAmount));
			         flag = true;
			         break;
			         
			default : System.out.println("Please enter a valid choice : ");
			          
			}
			if(flag)
			{
				break;
			}
		}
		
		sc.close();
	}

}