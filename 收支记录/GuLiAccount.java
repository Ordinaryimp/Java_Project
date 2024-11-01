class  GuLiAccount{
	public static void main(String[] args) 
	{
		boolean isFlag=true;//控制循环结束
		
		int balance = 10000;//初始金额

		String info ="";//记录收支信息

		while(isFlag){
			System.out.println("----------谷粒记账软件-----------\n");
			System.out.println("             1.收支明细");
			System.out.println("             2.登记收入");
			System.out.println("             3.登记支出");
			System.out.println("             4.退    出\n");
			System.out.print("             请选择（1-4）:");
			char selection = Utility.readMenuSelection();	//获取用户的选项：'1' '2'  '3'  '4'
			
			switch(selection){
				case '1':
					System.out.println("----------当前收支明细----------");
					System.out.println("收支\t账户金额\t收支金额\t说   明\n");
					System.out.println(info);
					System.out.println("--------------------------------");
					break;
				case '2':
					System.out.print("本次收入金额:");
					int money = Utility.readNumber();

					if(money>0){
						balance += money;
					}
					System.out.print("本次收入说明:");
					String addDec = Utility.readString();

					info +="收入\t"+balance+"\t\t"+money+"\t\t"+addDec+"\n";
					System.out.println("----------登记完成-----------");
					break;
				case '3':
					System.out.print("本次支出金额");
					int money2 = Utility.readNumber();

					if(money2>0&&balance>=money2){
						balance -= money2;
					}
					System.out.print("本次支出说明:");
					String minusDec = Utility.readString();

					info +="支出\t"+balance+"\t\t"+money2+"\t\t"+minusDec+"\n";
					System.out.println("----------登记完成-----------");
	
					break;
				case '4':
					System.out.println("\n确认是否退出(N/Y):");
					char isExit = Utility.readConfirmSelection();
					if(isExit=='Y'){
						isFlag=false;
					}
					break;
			}
	

		}
		
	}
}
