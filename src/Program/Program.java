package Program;

import Entities.Lesson;
import Entities.Task;
import Entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> lessonList = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int N = sc.nextInt();;

        for (int i = 0; i< N; i++){
            System.out.println("Dados da "+ (i+1)+ "a aula:");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char type = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String title = sc.nextLine();
            if (type == 'c'){
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                lessonList.add(new Video(title, url, seconds));
            }
            else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                lessonList.add(new Task(title, description, questionCount));
            }

        }
        int totalDuration = 0;
        for (Lesson duration: lessonList) {
            totalDuration += duration.duration();
        }
        System.out.println();

        System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");
        sc.close();
    }
}
