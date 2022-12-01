public class TowersOfHanoi{
	public static void main(String[] args){
		int numOfDisks = 3;

		TowersOfHanoi toh = new TowersOfHanoi();

		toh.towersOfHanoi(numOfDisks, "A", "C", "B");
	}

	void towersOfHanoi(int n, String src, String des, String aux){
		TowersOfHanoi toh = new TowersOfHanoi();

		if(n==0)
			return;

		toh.towersOfHanoi(n-1, src, aux, des);
		System.out.println("Move Disk "+ n + " from "+ src +" to "+ des);
		toh.towersOfHanoi(n-1, aux, des, src);
	}
}