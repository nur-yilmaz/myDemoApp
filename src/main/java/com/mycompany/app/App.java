package com.mycompany.app;
import java.util.ArrayList;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App 
{
    public static String determinant(ArrayList<Integer> firstArray,ArrayList<Integer> secondArray,ArrayList<Integer> thirdArray, int e) {
        System.out.println("inside determinant");
        if (firstArray == null || secondArray == null ||thirdArray == null )
        	return "One of the boxes is null";
        if(firstArray.size() != 3)
            return "Every box needs to contain exactly 3 integers.";
    
        if (firstArray.size() != secondArray.size() || firstArray.size() != thirdArray.size() )
        	 return "Every box needs to contain exactly 3 integers.";
    
        int determinant = firstArray.get(0)*(secondArray.get(1)*thirdArray.get(2) - secondArray.get(2)*thirdArray.get(1))-firstArray.get(1)*(secondArray.get(0)*thirdArray.get(2)- secondArray.get(2)*thirdArray.get(0))+ firstArray.get(2)*(secondArray.get(0)*thirdArray.get(1)- secondArray.get(1)*thirdArray.get(0));
        if(e==determinant)
            return "Congrats. You guessed right! The determinant is " + e + "! ";
        return "Sorry, but you guessed wrong. The determinant is " + determinant + ". Please try again! ";
    }
    public static void main( String[] args )
    {
        port(getHerokuAssignedPort());
        get("/",(req,res)->"Hello World");
        post("/compute",(req,res)->  {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> firstInputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            firstInputList.add(value);
          }
          System.out.println(firstInputList);

          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> secondInputList = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            secondInputList.add(value);
          }
          System.out.println(secondInputList);

          String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> thirdInputList = new java.util.ArrayList<>();
          while (sc3.hasNext())
          {
            int value = Integer.parseInt(sc3.next().replaceAll("\\s",""));
            thirdInputList.add(value);
          }
          System.out.println(thirdInputList);

          String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);

          String result = App.determinant(firstInputList, secondInputList, thirdInputList, input4AsInt);

          Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "Hi, let's begin!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    }
    

