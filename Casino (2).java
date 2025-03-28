import java.io.*;
import java.util.*;
public class Casino {
    public static void main(String[] args) throws IOException {
        FileReader fin = new FileReader("C:\\Users\\DELL\\OneDrive - Chella Software Pvt Ltd\\Perichi\\ReplyHack\\ReplyHack\\src\\input.txt");
        BufferedReader in = new BufferedReader(fin);
        FileWriter fout = new FileWriter("C:\\Users\\DELL\\OneDrive - Chella Software Pvt Ltd\\Perichi\\ReplyHack\\ReplyHack\\src\\output.txt");
        BufferedWriter bout = new BufferedWriter(fout);
        PrintWriter pout = new PrintWriter(bout);
        int t = Integer.parseInt(in.readLine());
        

        for (int i = 1; i <= t; i++) {
            String st = in.readLine();
            String[] str = st.split(" ");
            int n = Integer.parseInt(str[0]);
            int bf = Integer.parseInt(str[1]);
            int bi = Integer.parseInt(str[2]);
            

            int[][] slots = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = in.readLine();
                str = st.split(" ");
                slots[j][0] = Integer.parseInt(str[0]);
                slots[j][1] = Integer.parseInt(str[1]);
            }

            int result = solveCase(n, bf, bi, slots);
            pout.println("Case #"+ i + ": " + result);
        }
        pout.close();
        in.close();
    }

    public static int solveCase(int n, int bf, int bi, int[][] mach) {
        Arrays.sort(mach, (a, b) -> (b[1]-b[0]) - (a[1]-a[0]));
        int ini = bi;
        int res = 0;
        while (ini < bf) {
            int i;
            for (i = 0; i < n; i++) {
                if (mach[i][0] <= ini) {
                    ini += mach[i][1] - mach[i][0];
                    res++;
                    break;
                }
            }

            if (i == n) {
                break;
            }
        }

        return res;
    }
}
