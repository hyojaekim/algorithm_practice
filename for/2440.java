import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++){
            for(int j=num-i; j>0; j--){
                sb.append("*");
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
