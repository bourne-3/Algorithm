package CodeTop.Tencent;

/**
    注意公式  (rand7() - 1 ) * 7 + rand7();
 */
public class prac1 {

    public static void main(String[] args) {

    }

    public int rand10() {
        while(true){
            int num = (rand7() - 1) * 7 + rand7();  //49
            if (num <= 40) return 1 + num% 10;
            // 剩余的41 - 49
            num =  (num - 40 - 1) * 7 + rand7();  // 63
            if (num <= 60) return 1 + num% 10;
            // 61-63
            num = (num - 60 - 1) * 7 + rand7();  // 21
            if (num <= 20) return 1 + num% 10;
        }
    }

    public int rand7() {
        return -1;
    }
}
