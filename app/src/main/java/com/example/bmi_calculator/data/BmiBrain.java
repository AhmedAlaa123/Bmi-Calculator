package com.example.bmi_calculator.data;

public class BmiBrain {
    private BmiModel bmiModel;
    private static BmiBrain instance;
    public static BmiBrain getInstance()
    {
        if(instance==null)
        {
            instance=new BmiBrain();
        }
        return instance;
    }
   public void setBmiModel(BmiModel bmiModel)
   {
       this.bmiModel=bmiModel;
       bmiModel.setBmi(calculateBmi());

   }
    private int calculateBmi()
    {
        return  (int)(bmiModel.getWeight()/Math.pow(bmiModel.getHeight()/100.0,2.0));
    }
   public String getResultText()
   {
       if(bmiModel.getBmi()>=25)
           return "OverWeight";
       if(bmiModel.getBmi()>=18.0)
           return "Normal";
       return "Underweight";

   }
   public String getInterpretation()
    {
        if(bmiModel.getBmi()>=25)
            return "You have a higher than normal body weight.Try do exercise more.";
        if(bmiModel.getBmi()>=18.0)
            return "You have a normal weight. Good jop!";
        return "You have a lower normal weight. You can eat a bit more";
    }


}
