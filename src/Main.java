//Варіант 87, метод дихотомі, простої ітерації
public class Main {
    public static void main(String[] args) {
        double a = -2;
        double b = -1;
        double q = 0.202;
        double epsilon =  Math.pow(10, -4);
        System.out.println("Метод дихотомії!");
        double result = new Main().met_dehotomiya(a,b,epsilon);
        System.out.println("Результат:  " + result);
        System.out.println("Метод простої ітерації!");
        double result2 = new Main().met_iteration(q,epsilon);
        System.out.println("Результат:  " + result2);
    }
    private double met_dehotomiya(double a, double b, double epsilon){
        double x = 0;
        int count = 0;
        while(Math.abs(b-a) >= epsilon){
            x = (a+b)/2;
            if(get_value_function(x) == 0){
                System.out.println("Кількість ітерацій " + count);
                return 0;
            }
            System.out.println("Значення на ітерації " + count  + " = " + x);
            if (get_value_function(a) * get_value_function(x) >= 0){
                a = x;
            }
            else if(get_value_function(b) * get_value_function(x) >= 0) {
                b = x;
            }
            count++;
        }
        System.out.println("Значення на ітерації " + count  + " = " + (a+b)/2);
        System.out.println("Кількість ітерацій " + count);
        return (a+b)/2;
    }
    private double get_value_function(double x){
        return Math.pow(x,4) + 4*x - 2;
    }
    private double met_iteration(double q, double epsilon){
        double x_prev = -1.5;
        double x_next;
        double delta;
        int count = 0;
        do {
            x_next = fi(x_prev);
            delta = Math.abs(x_next - x_prev);
            x_prev = x_next;
            System.out.println("Значення на ітерації " + count  + " = " + x_next);
            count ++;
        }while ( delta >= ((1-q)/q)*epsilon);
        count --;
        System.out.println("Кількість ітерацій " + count);
        return x_next;
    }
    private double fi(double x){
        double under_root = 2.0/x-4.0;
        double res = 0;
        if(under_root < 0){
            under_root = -1 * under_root;
            res = Math.pow(under_root,(1.0/3.0));
            res = -1 * res;
            return res;
        }
        res = Math.pow(under_root,(1.0/3.0)); ;
        return res;
    }
}