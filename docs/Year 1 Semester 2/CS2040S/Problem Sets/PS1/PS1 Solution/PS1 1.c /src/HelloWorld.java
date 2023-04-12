public class HelloWorld{
    public static void main(String[] args) {
        Person me = new Person();
        System.out.println(me.Introduce());
    }

    public static class Person {
        private String name;
        private int age;
        private String favAlgo;
        private String school;

        public Person() {
            this.name = "Jihoon";
            this.age = 21;
            this.favAlgo = "Binary Search";
            this.school = "NUS";
        }

        public String Introduce(){
            return "Hello, my name is " + this.name
                    +". I am " + this.age+" years old and I am currently studying in " + this.school
                    +". My favourite algorithm is " + this.favAlgo + "."
                    +"\nHere are the solutions to the problems:"
                    +"\n\t1.a "+MysteryFunction(5,5)
                    +"\n\t1.b The code returns argA to the power of argB";
        }
    }

    static int MysteryFunction(int argA, int argB) {
        int c = 1;
        int d = argA;
        int e = argB;
        while (e > 0) {
            if (2 * (e / 2) != e) {
                c = c * d;
            }
            d = d * d;
            e = e / 2;
        }
        return c;
    }
}