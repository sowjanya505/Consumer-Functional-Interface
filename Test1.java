####Demo Program for Consumer Chaining:


 import java.util.function.*;
 class Movie
 {
	String name;
	String result;
	Movie(String name,String result)
	{
	this.name=name;
	this.result=result;
	}
 }
 class Test1
 {
	public static void main(String[] args)
	{
	Consumer<Movie> c1=m->System.out.println("Movie:"+m.name+" is ready to release");

	Consumer<Movie> c2=m->System.out.println("Movie:"+m.name+" is just Released and it is:"+m.result);

	Consumer<Movie> c3=m->System.out.println("Movie:"+m.name+" information storing in the database");

	Consumer<Movie> chainedC = c1.andThen(c2).andThen(c3);

	Movie m1= new Movie("mvy1","Hit");
	chainedC.accept(m1);

	Movie m2= new Movie("mvy2","Flop");
	chainedC.accept(m2);
	}
 }




Output:
Movie:mvy1 is ready to release 
Movie:mvy1 is just Released and it is:Hit
Movie:mvy1 information storing in the database Movie:mvy2 is ready to release
Movie:mvy2 is just Released and it is:Flop 
Movie:mvy2 information storing in the database
