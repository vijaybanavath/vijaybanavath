// Java implementation of above design for Cricket App. The
// problems with this design are discussed below.
  
// A class that gets information from stadium and notifies
// display elements, CurrentScoreDisplay & AverageScoreDisplay
class CricketData
{
    int runs, wickets;
    float overs;
    CurrentScoreDisplay currentScoreDisplay;
    AverageScoreDisplay averageScoreDisplay;
  
    // Constructor
    public CricketData(CurrentScoreDisplay currentScoreDisplay,
                       AverageScoreDisplay averageScoreDisplay)
    {
        this.currentScoreDisplay = currentScoreDisplay;
        this.averageScoreDisplay = averageScoreDisplay;
    }
  
    // Get latest runs from stadium
    private int getLatestRuns()
    {
        // return 90 for simplicity
        return 90;
    }
  
    // Get latest wickets from stadium
    private int getLatestWickets()
    {
        // return 2 for simplicity
        return 2;
    }
  
    // Get latest overs from stadium
    private float getLatestOvers()
    {
        // return 10.2 for simplicity
        return (float)10.2;
    }
  
    // This method is used update displays when data changes
    public void dataChanged()
    {
        // get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();
  
        currentScoreDisplay.update(runs,wickets,overs);
        averageScoreDisplay.update(runs,wickets,overs);
    }
}
  
// A class to display average score. Data of this class is
// updated by CricketData
class AverageScoreDisplay
{
    private float runRate;
    private int predictedScore;
  
    public void update(int runs, int wickets, float overs)
    {
        this.runRate = (float)runs/overs;
        this.predictedScore = (int) (this.runRate * 50);
        display();
    }
  
    public void display()
    {
        System.out.println("\nAverage Score Display:\n" +
                           "Run Rate: " + runRate +
                           "\nPredictedScore: " + predictedScore);
    }
}
  
// A class to display score. Data of this class is
// updated by CricketData
class CurrentScoreDisplay
{
    private int runs, wickets;
    private float overs;
  
    public void update(int runs,int wickets,float overs)
    {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }
  
    public void display()
    {
        System.out.println("\nCurrent Score Display: \n" +
                           "Runs: " + runs +"\nWickets:"
                           + wickets + "\nOvers: " + overs );
    }
}
 
// Interface named Shape
// Shape.java
 interface Shape {
    void draw();
}
// Class 1
// Class 1 will be implementing the Shape interface
 
// Rectangle.java
 class Rectangle implements Shape {
 
    // Overriding the method
    @Override public void draw()
    {
        // /Print statement to execute when
        // draw() method of this class is called
        // later on in the main() method
        System.out.println("Shape: Rectangle");
    }
}

// Class 1
// Class 1 will be implementing the Shape interface
 
// Circle.java
class Circle implements Shape {
 
    // Overriding the method
    @Override public void draw()
    {
        // /Print statement to execute when
        // draw() method of this class is called
        // later on in the main() method
        System.out.println("Shape: Circle");
    }
}
// Class 2
// Abstract class
// ShapeDecorator.java
 abstract class ShapeDecorator implements Shape {
 
    // Protected variable
    protected Shape decoratedShape;
 
    // Method 1
    // Abstract class method
    public ShapeDecorator(Shape decoratedShape)
    {
        // This keywordd refers to current object itself
        this.decoratedShape = decoratedShape;
    }
 
    // Method 2 - draw()
    // Outside abstract class
    public void draw() { decoratedShape.draw(); }
}
// Class 3
// Concrete class extending the abstract class
// RedShapeDecorator.java
 class RedShapeDecorator extends ShapeDecorator {
 
    public RedShapeDecorator(Shape decoratedShape)
    {
        super(decoratedShape);
    }
 
    @Override public void draw()
    {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }
 
    private void setRedBorder(Shape decoratedShape)
    {
      // Display message whenever function is called
        System.out.println("Border Color: Red");
    }
}
 
// DesignPatterns class which had both Observer and Decorator design patterns
class DesignPattern
{
    public static void main(String args[])
    {
        // Create objects for testing => Decorator Design Pattern
        AverageScoreDisplay averageScoreDisplay =
                                       new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay =
                                       new CurrentScoreDisplay();
  
        // Pass the displays to Cricket data
        CricketData cricketData = new CricketData(currentScoreDisplay,
                                                  averageScoreDisplay);
  
        // In real app you would have some logic to call this
        // function when data changes
        cricketData.dataChanged();
        
        
        
        // Creating an object of Shape interface=> Observer Design pattern
        // inside the main() method
        Shape circle = new Circle();
 
        Shape redCircle
            = new RedShapeDecorator(new Circle());
 
        Shape redRectangle
            = new RedShapeDecorator(new Rectangle());
 
        // Display message
        System.out.println("Circle with normal border");
 
        // Calling the draw method over the
        // object calls as created in
        // above classes
 
        // Call 1
        circle.draw();
 
        // Display message
        System.out.println("\nCircle of red border");
 
        // Call 2
        redCircle.draw();
 
        // Display message
        System.out.println("\nRectangle of red border");
 
        // Call 3
        redRectangle.draw();
    }
}