import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet11 {


    public ArrayList<String> fizzBuzz(int start, int end) {

        if (start >= end) {
            return null;
        }

        ArrayList<String> answer = new ArrayList<String>();
        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(Integer.toString(i));
            }
        }

        return answer;

    }

    public int maxSpan(ArrayList<Integer> numbers) {

        if (numbers == null) {
            return -1;
        }

        if (numbers.size() == 0) {
            return 0;
        }

        HashMap<Integer, Integer> firstAppearance = new HashMap<Integer, Integer>();
        int span = 1;
        int maxSpan = 1;

        for (int i = 0; i < numbers.size(); i++) {
            Integer s = firstAppearance.get(numbers.get(i));
            if (s == null) {
                firstAppearance.put(numbers.get(i), i);
            } else {
                span = i - s + 1;
                if (span > maxSpan) {
                    maxSpan = span;
                }
            }
        }

        return maxSpan;

    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {

        if (numbers == null) {
            return null;
        }

        int threeValues = 0;
        int fourValues = 0;
        int firstThreeIndex = 0;
        int firstFourIndex = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 3) {
                if (firstThreeIndex == -1) {
                    firstThreeIndex = i;
                }
                if (i != numbers.size()-1 && numbers.get(i+1) == 3) {
                    return null;
                }
                threeValues++;
            } else if (numbers.get(i) == 4) {
                if (firstFourIndex == -1) {
                    firstFourIndex = i;
                }
                fourValues++;
            }
        }

        if (threeValues != fourValues) {
            return null;
        }

        for (int k = firstThreeIndex; k < numbers.size(); k++) {
            if (numbers.get(k) == 4) {
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(j) == 3) {
                        int t = numbers.get(j+1);
                        numbers.set(j+1, numbers.get(k));
                        numbers.set(k, t);
                    }
                }
            }
        }

        return numbers;

    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {

        if (numbers == null) {
            return null;
        }

        int fourValues = 0;
        int fiveValues = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 4) {
                if (i != numbers.size()-1 && numbers.get(i+1) == 4) {
                    return null;
                }
                fourValues++;
            } else if (numbers.get(i) == 5) {
                fiveValues++;
            }
        }

        if (fourValues == 0 && fiveValues == 0) {
            return null;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 5) {
                for (int k = 0; k < numbers.size(); k++) {
                    if (numbers.get(k) == 4 && numbers.get(k+1) != 5) {
                        int t = numbers.get(k+1);
                        numbers.set(k+1, numbers.get(i));
                        numbers.set(i, t);
                    }
                }
            }
        }
        return numbers;

    }

    public boolean canBalance(ArrayList<Integer> numbers) {

        if (numbers == null || numbers.size() == 0) {
            return false;
        }

        int leftBalance = 0;
        int rightBalance = 0;



        for (int i = 0; i < numbers.size(); i++) {


            for (int j = i; j >= 0; j--) {
                leftBalance += numbers.get(j);
            }
            for (int k = i+1; k < numbers.size(); k++) {
                rightBalance += numbers.get(k);
            }
            if (rightBalance == leftBalance) {
                return true;
            }

            leftBalance = 0;
            rightBalance = 0;
        }

        return false;

    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {

        if (outer == null || inner == null || outer.size() == 0 || inner.size() == 0) {
            return false;
        }

        for (int i = 0; i< outer.size()-1; i++) {
            if (outer.get(i) > outer.get(i+1)) {
                return false;
            }
        }

        for (int k = 0; k < inner.size()-1; k++) {
            if (inner.get(k) > inner.get(k+1)) {
                return false;
            }
        }

        boolean found = true;
        for (int j = 0; j < inner.size(); j++) {
            int test = 0;
            for (int m = 0; m < outer.size(); m++) {
                if (outer.get(m) == inner.get(j)) {
                    test += 1;
                }
            }
            if (test == 0) {
                return false;
            }
        }

        return true;

    }

    public ArrayList<Integer> squareUp(int n) {

        if (n < 0) {
            return null;
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= n; k++) {
                if (k > n-i) {
                    answer.add(n-k+1);
                }
                else {
                    answer.add(0);
                }
            }
        }



        return answer;

    }

    public ArrayList<Integer> seriesUp(int n) {

        if (n < 0) {
            return null;
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            for (int h = 0; h < i; h++) {
                answer.add(h+1);
            }
        }

        return answer;

    }

    public int maxMirror(ArrayList<Integer> numbers) {

        if (numbers == null) {
            return -1;
        }

        int lowIdx = 0;
        int highIdx = 0;
        int currentMirror = 0;
        int maxMirror = 0;

        for (int i = 0; i < numbers.size(); i++) {
            for (int k = numbers.size() - 1; k >= 0; k--) {
                if (numbers.get(i) == numbers.get(k)) {
                    currentMirror = 1;
                    lowIdx = i + 1;
                    highIdx = k - 1;

                    while
                    ((lowIdx <= numbers.size() - 1 && highIdx >= 0) &&
                            (numbers.get(lowIdx) == numbers.get(highIdx))) {
                        highIdx-=1;

                        lowIdx+=1;

                        currentMirror+=1;
                    }

                    if (currentMirror > maxMirror) {
                        maxMirror = currentMirror;
                    }
                }
            }
        }

        return maxMirror;

    }

    public int countClumps(ArrayList<Integer> numbers) {

        if (numbers == null) {
            return -1;
        }
        int clumps = 0;

        boolean inClump = false;

        for (int i = 0; i < numbers.size()-1; i++) {

            if ((numbers.get(i) == numbers.get(i+1)) && !inClump) {
                clumps+=1;
                inClump = true;
            }
            else if (inClump && (numbers.get(i) != numbers.get(i-1))) {
                inClump = false;
            }
        }
        return clumps;
    }
}