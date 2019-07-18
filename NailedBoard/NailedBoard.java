
import java.util.*;
import java.util.Arrays;

public class NailedBoard {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] data = new int[n];
		ArrayList<int[]> myData = new ArrayList<>();
		ArrayList<Integer> freq = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			data[i] = input.nextInt();
		}

		Arrays.sort(data);

		// find how many distinct values
		for (int i = 0; i < n; i++) {
			int occur = 1;
			boolean same = true;
			while (same) {
				if (i < n - 1 && data[i + 1] == data[i]) {
					occur = occur + 1;
					i++;
				} else
					same = false;
			}
			int[] a = new int[2];
			a[0] = data[i];
			a[1] = occur;
			myData.add(a);
		}
		
		
		for (int i = 0; i < myData.size() - 1; i++) {
			int[] current = myData.get(i);
			if (current[1] > 1) {
				for (int k = 0; k < current[1] / 2; k++)
					freq.add(current[0] * 2);
			}

			for (int j = i + 1; j < myData.size(); j++) {
				int[] next = myData.get(j);
				if (current[1] < next[1]) {
					for (int k = 0; k < current[1]; k++)
						freq.add((current[0] + next[0]));
				} else
					for (int k = 0; k < next[1]; k++)
						freq.add((current[0] + next[0]));
			}
		}
		Collections.sort(freq);

		int l = freq.size();
		int maxFreq = 1;
		ArrayList<Integer> output = new ArrayList<>();
		if(myData.size()==1) {
			System.out.println(n/2 + " " + 1);
		}else {
			for (int i = 0; i < l; i++) {
				int occur = 1;
				boolean same = true;
				while(same) {
					if (i < l - 1 && freq.get(i).compareTo(freq.get(i + 1))==0) {
						occur = occur + 1;
						i++;
					}else
						same = false;
				}
				if(occur > maxFreq) {
					maxFreq = occur;
					output.clear();
					output.add(freq.get(i));
				}else if(occur == maxFreq)
					output.add(freq.get(i));
			}
			
			System.out.println(maxFreq + " " + output.size());
		}

	}

}
