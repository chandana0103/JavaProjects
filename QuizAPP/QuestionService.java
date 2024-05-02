package PROJECTS.QuizAPP;
import java.util.Scanner;

public class QuestionService {
    
    // int id[];
    // String question[];
    // String opt1[]
    Question[] qns=new Question[5];
    String selection[]=new String[5];

    public QuestionService(){

        qns[0]=new Question(1,"size of int","2","4","6","8","4");
        qns[1]=new Question(2,"size of double","2","4","6","8","8");
        qns[2]=new Question(3,"size of char","2","4","6","8","2");
        qns[3]=new Question(4,"size of long","2","4","6","8","8");
        qns[4]=new Question(5,"size of boolean","2","4","6","8","1");   
    }
    public void displayQuestion(){

        //qns[0]=new Question();
       for(Question q: qns){

        System.out.println(q);        //only object ref printed prints all qns and options
        System.out.println(q.getQuestion());    //only prints question filed
       }
       //System.out.println(qns[0].getQuestion());

    }
    public void playQuiz(){

        int i=0;
        for(Question q: qns){
            System.out.println("Question no :"+q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            
            Scanner sc= new Scanner(System.in);
            selection[i]=sc.nextLine();
            i++;
        }
        for (String s:selection){
            System.out.println("correct ans : ");
            System.out.println(s);
        }
    }
        public void printScore(){

            int score=0;
            for(int i=0;i<qns.length;i++){
                Question que=qns[i];
                String actualAns=que.getAnswer();
                String userAns=selection[i];

                if(actualAns.equals(userAns)){
                    score++;
                }
            }
            System.out.println("your score is :"+score);
        }
    
}
