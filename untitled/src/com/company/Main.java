package com.company;

import java.util.*;

public class Main {

    //implementing linkedlist and bubble sort of linkedlist
    class Node {
        int data;
        Node next;

        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode (int data){
        Node node = new Node(data);

        Integer[] arr = {6,2,10,13,1};
        Arrays.sort(arr);

        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public void sortList(){
        Node current = head;
        Node index = null;

        int temp;

        if(head == null){
            return;
        }else{
            while (current != null){
                index = current.next;

                while(index != null){
                    if (current.data > index.data){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;

            }
        }
    }

    public void display(){
        Node current = head;

        if (head == null){
            System.out.println("Empty Linked List");
            return;
        }else {
            while(current != null){
                System.out.print(current.data + ", ");

                current = current.next;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
	// write your code here
        Main noodes = new Main();

        noodes.addNode(9);
        noodes.addNode(6);
        noodes.addNode(4);
        noodes.addNode(2);

        noodes.display();

        noodes.sortList();

        noodes.display();
    }
}


class BinaryTree{
    static class Node{
        Node left;
        Node right;

        int root;

        public Node(int data){
            this.root = data;
            left = null;
            right = null;
        }
    }

    Node root;

    BinaryTree(int key){
        root = new Node(key);
    }

    BinaryTree(){
        root = null;
    }

    public void addRecursive(int data){
        if (root == null){
            root = new Node(data);
        }

        if (data < root.root){
            root.left = new Node(data);
        }else if (data > root.root){
            root.right = new Node(data);
        }else {
            return;
        }
    }

    public static void main(String[] args){

//        System.out.println(removeRepeatCharacter("loopsoof"));
//        System.out.println(addWithoutArithmeticOperator(4, 5));
//        System.out.println(FreqOfOccurence("He said he will be there", "he"));
//        BinaryTree tree = new BinaryTree();
//
//        tree.addRecursive(1);
//        tree.addRecursive(2);
//        tree.addRecursive(3);
//        tree.addRecursive(4);

//        List<Integer> lst1 = Arrays.asList(1,2,100);
//        List<Integer> lst2 = Arrays.asList(2,5,100);
//        List<Integer> lst3 = Arrays.asList(3,4,100);
//
//        List<List<Integer>> usage = Arrays.asList(lst1,lst2,lst3);
//
//        long ans = arrayManipulation(5,usage);

//        int ans = counting("00110");
//        char ans = maxOccuringChar("hello world");
//
//        List<String> names = new ArrayList<String>();
//        names.addAll(Arrays.asList("a", "b", "c", "d", "e", "f"));

        long st = repeatedString("aba", 10);
        System.out.println(st);

        List<Integer> arr = new ArrayList<>();
//
        arr.add(2);
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(4);
//
//        minimumBribes(arr);

        List<Integer> output = rotLeft1(arr, 9);

//        System.out.println(output);

//        tree.root = new Node(1);
//
//        tree.root.right = new Node(2);
//        tree.root.left = new Node(3);
//
//        tree.root.right.right = new Node(4);
//        tree.root.right.left = new Node(5);
    }

    public static String removeRepeatCharacter(String valuepassed){
        StringBuilder sb = new StringBuilder();

        char[] characters = valuepassed.toCharArray();

        for (char m: characters) {
            if(sb.toString().indexOf(m) == -1){
                sb.append(m);
            }
        }

        return sb.toString();
    }

    public static Integer addWithoutArithmeticOperator(int x, int y){
        while(y != 0 ){
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }

        return x;
    }

    public static Integer FreqOfOccurence(String statement, String comparator){
        String[] words = statement.split(" ");

        Integer i = 0;

        for (String word : words) {
            if(word.equalsIgnoreCase(comparator))
                i++;
        }

        return i;
    }

    public static List<Integer> rotLeft(List<Integer> a, int d){
        for (int i = 1; i <= d; i++ ){
            Integer c = 0;
            Integer firstValue = a.get(0);

            while (c < (a.size()-1)){
//                Integer q = c+1;
//                Integer value = a.get(q);
                a.set(c, a.get(c + 1));
                c = c+1;
            }
            a.set(a.size()-1, firstValue);
        }

        return a;
    }

    public static List<Integer> rotLeft1(List<Integer> a, int d){
        for (int i = 1; i <= d; i++ ){
            Integer c = 0;
            Integer firstValue = a.get(0);

            a.remove(0);
            a.add(firstValue);
        }

        return a;
    }

    public static void minimumBribes(List<Integer> q){
        int ans = 0;

        for(int i = q.size()-1; i >= 0; i--){
            int position = q.get(i) - (i+1);

            if(position > 2){
                System.out.println("too chaotic");
                return;
            }else{
                int st = Math.max(0, (q.get(i)-2));

                for (int j = st; j < i; j++){
                    if(q.get(j) > q.get(i)){
                        ans = ans + 1;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static int minimumswaps(int[] arr){
        int i = 0;
        int count = 0;
        int temp;
        int n = arr.length;

        while (i < n){
            if (arr[i] != (i+1)){
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                count++;
            }else{
                i++;
            }
        }
        return count;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries){
        long result = queries.get(0).get(2);

        Integer[] arr = new Integer[n];

        Arrays.fill(arr, 0);

        for (int i = 0; i < queries.size(); i++){
            List<Integer> query = queries.get(i);

            Integer startPoint = query.get(0) - 1;
            Integer finishPoint = query.get(1);
            Integer value = query.get(2);

            Integer k  = 0;

            while (k < n){

                arr[k] = arr[k] + 0;

                if (k >= startPoint && k < finishPoint)
                    arr[k] = arr[k] + value;

                if (arr[k] > result)
                    result = arr[startPoint];

                k++;
            }
            System.out.println("");
            for(Integer a : arr){
                System.out.print(a+",");
            }

//            System.out.println(arr);
        }

        return result;
    }

    public static int counting(String s){
        int totalNumber = 0;

        for (int i= 0; i<s.length(); i++){
            int j = i + 2;
            if(j > s.length())
                j = s.length();
            String subStr = s.substring(i, j);
            System.out.println(subStr);

            if (subStr.equalsIgnoreCase("00") || subStr.length() < 2)
                continue;

            totalNumber++;
        }

        return totalNumber;
    }

    public static char maxOccuringChar(String str){
        int ctr[] = new int[256];

        int l = str.length();

        for (int i = 0; i < l; i++){
            ctr[str.charAt(i)]++;
        }

        int max = -1;

        char result = ' ';

        for (int i = 0; i < l; i++){
            if (max < ctr[str.charAt(i)]){
                max = ctr[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;
    }

    public static int countingValleys(int steps, String path){
        int counter = 0;
        int totalValleys = 0;

        Character c1 = new Character('U');
        Character c2 = new Character('D');

        for (int i = 0; i < steps; i++){
            char pathChar = path.charAt(i);

            if (c1 == pathChar){
                counter++;
            }else if (c2 == pathChar){
                counter--;

                if (counter == -1){
                    totalValleys++;
                }
            }

        }

        return totalValleys;
    }

    public static int jumpingOnCloud(List<Integer> c){
        int jumps = 0;

        for (int i = 0; i < c.size(); i++){
            int nxtStep = c.get(i + 1);
            int nxtSteps = 1;

            if (i < c.size()- 2)
                nxtSteps = c.get(i+2);

            if (nxtSteps == 0){
                jumps++;
                i++;
            }else if(nxtStep == 0){
                jumps++;
            }

        }

        return jumps;
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        char input = 'a';
        int clen = s.length();
        int i = 0;
        if (clen == 1 && s.charAt(0) == input)
            return n;
        long count = 0L;
        long strCount = countCharacters(s, input);
        while (i < n){
            if ((i + s.length()) > n){
                String substring = s.substring(0, (int)(n-i));
                count += countCharacters(substring, input);
                break;
            }
            count += strCount;
            i += s.length();
        }
        return count;
    }

    private static long countCharacters(String s, char input){
        long count = 0L;

        for (int j = 0; j < s.length(); j++){
            if (s.charAt(j) == input)
                count++;
        }

        return count;
    }

    public static long shortRepeatedString(String s,long n){
        char input = 'a';

        long totalNumOfRecurrence = n/s.length();
        long remainder = n%s.length();

        long totalNumOfA =0l;

        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == input){
                totalNumOfA += totalNumOfRecurrence;
                if(i < remainder)
                    totalNumOfA++;
            }
        }

        return totalNumOfA;
    }

}

class Sorting{

    public static int clapoint(String[] ops){
        int result = Integer.MIN_VALUE;

        List<Integer>  arr = new ArrayList<>();

        for (String str : ops){
            str.charAt(1) == 'a'

        }
    }

    public static void main(String[] args){
        int[] intArrays = {20, 35, -15, 7, 55, 1, -22};
        int[] testArrays = {2,3,4,3,2,6,7, 8, 8, 10, 9};
        int[] testRadixArray = {4725, 4586, 1330, 8792, 1594, 5729};
        String[] stringArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        List<String> output = new ArrayList<>();

        radixSortAlphabet(stringArray, 26, 5);
//        insertionSort(intArrays, intArrays.length);
//        mergeSort(intArrays, 0, intArrays.length);
//        countingSort(testArrays, 2, 10);
//        quickSort(intArrays, 0, intArrays.length);
//        radixSort(testRadixArray, 10, 4);

        for(String i : stringArray){
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] intArrays){
        for (int lastUnsortedArrayIndex = intArrays.length - 1; lastUnsortedArrayIndex > 0; lastUnsortedArrayIndex --) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedArrayIndex; i++){
                if (intArrays[largest] < intArrays[i]){
                    largest = i;
                }
            }
            swap(intArrays, largest, lastUnsortedArrayIndex);
        }
    }

    private static void insertionSort(int[] intArrays, int index){
        //Insertion sort
//        for (int firstUnsortedIndex = 0; firstUnsortedIndex < intArrays.length; firstUnsortedIndex++){
//            int newElement = intArrays[firstUnsortedIndex];
//
//            int i;
//            for (i = firstUnsortedIndex; i > 0 && intArrays[i - 1] > newElement; i--){
//                intArrays[i] = intArrays[i-1];
//            }
//
//            intArrays[i] = newElement;
//        }

        if (index < 2)
            return;

        insertionSort(intArrays, index - 1);

        int newElement = intArrays[index - 1];

        int i;
        for (i = index - 1; i > 0 && intArrays[i - 1] > newElement; i--){
               intArrays[i] = intArrays[i-1];
        }

        intArrays[i] = newElement;
    }

    private static void shellSort(int[] intArrays){
        //Shell sort is an improvement over insertion sort and can also be done on bubble sort
        //Shell sort an update over Insertion sort
        for (int gap = intArrays.length/2; gap > 0; gap /=2){
            for (int i = gap; i < intArrays.length; i++){
                int newElement = intArrays[i];
                int j = i;

                while ( j >= gap && intArrays[j - gap] > newElement){
                    intArrays[j] = intArrays[j - gap];
                    j -= gap;
                }

                intArrays[j] = newElement;
            }
        }
    }

    public static int recursiveFactorial(int num){
        if (num == 0)
            return 1;

        return num * recursiveFactorial(num - 1);
    }

    private static int iterativeFactorial(int num ){
        if (num == 0)
            return 1;

        int factorial = 1;

        for(int i = 1; i < num; i++){
            factorial *= i;
        }

        return factorial;
    }

    private static void mergeSort(int[] array, int start, int end){
        if(end - start < 2){
            return;
        }

        int mid = (start + end)/2;

        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    //{20, 35, -15, 7, 55, 1, -22};
    private static void merge(int[] input, int start, int mid, int end){
        if (input[mid - 1] >= input[mid])
            return;

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end){
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    private static void recursion(int[] intArrays){

    }

    private  static void swap(int[] array, int i, int j){
        if(i == j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //{20, 35, -15, 7, 55, 1, -22}
    private static void quickSort(int[] array, int start, int end){
        if ((end - start) < 2)
            return;


        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    //{20, 35, -15, 7, 55, 1, -22}
    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];

        int i = start;
        int j = end;

        while (i < j){
            while (i < j && array[--j] >= pivot);

            if(i < j){
                array[i] = array[j];
            }

            while (i < j && array[++i] <= pivot);

            if (i < j)
                array[j] = array[i];
        }

        array[j] = pivot;

        return j;
    }

    private static void countingSort(int[] array, int min, int max){
        int[] countArray= new int[(max - min) + 1];

        for (int i = 0; i < array.length; i++){
            //this portion of the count array gets the total count of each of the element in the array
            countArray[array[i] - min]++;
        }

        int j =  0;

        for (int i = min; i <= max; i++){
            while (countArray[i - min] > 0){
                array[j++] = i;
                countArray[i - min]--;
            }
        }
    }

    private static void radixSort(int[] array, int radix, int width){
        for (int i =0; i < width; i++){
            singleRadixSort(array, i, radix);
        }
    }

    private static void singleRadixSort(int[] array, int position, int radix){
        int numOfItems = array.length;

        int[] countArray = new int[radix];

        for (int value: array){
            int post = getDigit(position, value, radix);
            countArray[post]++;
        }
        /**the loop below is to make sure it is a stable sort algorithm
         * Adjust the count array by shifting the position forward**/
        for(int j = 1; j < radix; j++){
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numOfItems];
        for (int tempIndex = numOfItems - 1; tempIndex >= 0; tempIndex--){
            int post = getDigit(position, array[tempIndex], radix);
            temp[--countArray[post]] = array[tempIndex];
        }

        //Copy the array from temp into the main array
        for (int tempIndex = 0; tempIndex < numOfItems; tempIndex++){
            array[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int position, int value, int radix){
        return value / (int) Math.pow(radix, position) % radix;
    }

    private static void radixSortAlphabet(String[] array, int radix, int width){
        for (int i = width - 1; i >= 0; i--){
            singleRadixSortAlphabet(array, i, radix);
        }
    }

    private static void singleRadixSortAlphabet(String[] array, int position, int radix){
        int numOfItems = array.length;

        int[] countArray = new int[radix];

        for (String value: array){
            int post = getAlphabetIndex(position, value);
            countArray[post]++;
        }
        /**the loop below is to make sure it is a stable sort algorithm
         * Adjust the count array by shifting the position forward**/
        for(int j = 1; j < radix; j++){
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numOfItems];
        for (int tempIndex = numOfItems - 1; tempIndex >= 0; tempIndex--){
            int post = getAlphabetIndex(position, array[tempIndex]);
            temp[--countArray[post]] = array[tempIndex];
        }

        //Copy the array from temp into the main array
        for (int tempIndex = 0; tempIndex < numOfItems; tempIndex++){
            array[tempIndex] = temp[tempIndex];
        }
    }

    private static int getAlphabetIndex(int position, String value){
        return value.charAt(position) - 'a';
    }
}

class EmployeeSinglyLinkedList{
    private EmployeeNode head;

    public void addToFront(Integer employee){
        EmployeeNode node = new EmployeeNode(employee);

        node.setNext(head);
        head = node;
    }

    public void insertSorted(Integer value){
        if (head ==null || head.getEmployee() >= value){
            addToFront(value);
            return;
        }

        EmployeeNode current = head.getNext();
        EmployeeNode prevous = head;

        while (current != null && !(current.getEmployee() >= value)){
            prevous = current;
            current = current.getNext();
        }

        EmployeeNode newNode = new EmployeeNode(value);

        newNode.setNext(current);
        prevous.setNext(newNode);
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD ->");
        while (current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.print("null");
    }
    public static String newList( String[] students ) {
//Insert your code here
        StringBuilder sb = new StringBuilder();

        for (String str : students){

            String[] arr = str.split(" ");

            sb.append(arr[0]);
            sb.append(" ");
            sb.append(arr[1]);
            sb.append("-");

            Integer sum = 0;
            for (String a : arr){
                System.out.println(a);
                try{
                    Integer value = Integer.parseInt(a);
                    if(value <= 10)
                        sum += value;
                }catch(Exception e){
                    continue;
                }
            }

            Integer total = arr.length - 2;

            Integer average = sum / total;

            sb.append(average.toString());
            sb.append(";");
        }

        return sb.toString();
    }

    private StringNode headStr;

    public void addToFrontStr(String employee){
        StringNode node = new StringNode(employee);

        node.setNext(headStr);
        headStr = node;
    }

    public void push(String employee){
        addToFrontStr(employee);
    }

    public String pop(){
        if (headStr == null){
            return null;
        }

        String value = headStr.getStr();

        if(headStr.getNext() == null ){
            head = null;
        }

        headStr = headStr.getNext();

        return value;
    }

    public String peek(){
        return headStr.getStr();
    }

    public static void main(String[] args){
        EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();

//        list.push("i");
//        list.push("e");
//        list.push("g");
//
//        System.out.println(list.peek());
//        System.out.println(list.pop());
//        System.out.println(list.peek());
        System.out.println(list.checkPalindrome("I did, did I"));
        System.out.println(list.checkPalindrome("Racecar"));
        System.out.println(list.checkPalindrome("hello"));
    }

    public boolean checkPalindrome(String str){
        str = str.replaceAll("\\p{Punct}", "");
        str = str.replaceAll(" ", "");
        System.out.println(str);

        for (Character ch : str.toCharArray()){
            push(ch.toString());
//            System.out.println(peek());
        }

        for (Character ch : str.toCharArray()){
            String value = pop();
            if(!value.equalsIgnoreCase(ch.toString()))
                return false;
        }

        return true;
    }

    public boolean checkForPalindrome(String string){
        LinkedList<Character> stack = new LinkedList<>();

        StringBuilder strNoPunctuation = new StringBuilder(string.length());

        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z'){
                stack.push(c);
                strNoPunctuation.append(c);
            }
        }

        StringBuilder testPalindrome = new StringBuilder(string.length());
        while (!stack.isEmpty()){
            testPalindrome.append(stack.pop());
        }

        return strNoPunctuation.toString().equals(testPalindrome.toString());
    }
}

class StringNode{
    private String str;
    private StringNode next;

    public StringNode(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public StringNode getNext() {
        return next;
    }

    public void setNext(StringNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StringNode{" +
                "str='" + str + '\'' +
                ", next=" + next +
                '}';
    }
}

class EmployeeNode{
    private Integer employee;
    private EmployeeNode next;

    public EmployeeNode(Integer employee) {
        this.employee = employee;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }


    public String toString() {
        return employee.toString();
    }
}

class Employee{
    private String firstName;
    private String lastName;
    private Integer id;

    public Employee(String firstName, String lastName, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}

class EmployeeDoblyLinkedNode{
    private Employee employee;
    private EmployeeDoblyLinkedNode next;
    private EmployeeDoblyLinkedNode prev;

    public EmployeeDoblyLinkedNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDoblyLinkedNode getNext() {
        return next;
    }

    public void setNext(EmployeeDoblyLinkedNode next) {
        this.next = next;
    }

    public EmployeeDoblyLinkedNode getPrev() {
        return prev;
    }

    public void setPrev(EmployeeDoblyLinkedNode prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDoblyLinkedNode node = (EmployeeDoblyLinkedNode) o;
        return employee.equals(node.employee) &&
                next.equals(node.next) &&
                prev.equals(node.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, next, prev);
    }

    public String toString(){
        return employee.toString();
    }
}

class EmployeeDoublyLinkedList{
    private EmployeeDoblyLinkedNode head;
    private EmployeeDoblyLinkedNode tail;
    private int size;

    public void addToTail(Employee employee){
        EmployeeDoblyLinkedNode node = new EmployeeDoblyLinkedNode(employee);

        if (head == null){
            head = node;
            tail = node;
        }else {
            tail.setNext(node);
            node.setPrev(tail);
        }

        tail = node;

        size ++;
    }

    public void addToFront(Employee employee){
        EmployeeDoblyLinkedNode node = new EmployeeDoblyLinkedNode(employee);
        node.setNext(head);

        if (head == null){
            tail = node;
        }else{
            tail.setNext(node);
        }

        head = node;

        size++;
    }

    public EmployeeDoblyLinkedNode removeFromFront(){
        if (head == null){
            return null;
        }

        EmployeeDoblyLinkedNode node = head;
        if (head.getNext() == null){
            tail = null;
        }else{
            head.getNext().setPrev(null);
        }
        head = head.getNext();
        size --;
        node.setNext(null);
        return node;
    }

    public EmployeeDoblyLinkedNode removeFromTail(){
        if (head == null){
            return null;
        }

        if (tail.getPrev() == null){
            head = null;
        }else{
            tail.getPrev().setNext(null);
        }

        EmployeeDoblyLinkedNode node = tail;

        tail = tail.getPrev();
        size--;

        node.setPrev(null);
        return node;
    }

    public boolean addBefore(Employee toBeAdded, Employee before){
        if(head == null)
            return false;
        EmployeeDoblyLinkedNode current = head;
        EmployeeDoblyLinkedNode toBeAddedNode = new EmployeeDoblyLinkedNode(toBeAdded);

        while (current != null && !current.getEmployee().equals(before)){
            current = current.getNext();
        }

        if (current == null)
            return false;

        toBeAddedNode.setPrev(current.getPrev());
        toBeAddedNode.setNext(current);
        current.setPrev(toBeAddedNode);

        if (head == current){
            head = toBeAddedNode;
        }else{
            toBeAddedNode.getPrev().setNext(toBeAddedNode);
        }

        size++;
        return true;
    }

    public void printList(){
        EmployeeDoblyLinkedNode current = head;
        System.out.print("HEAD ->");
        while (current != null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.print("null");
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        Employee joyJones = new Employee("Joy", "Jones", 124);

        list.addToTail(new Employee("Jane", "Jones", 234));
        list.addToTail(joyJones);
        list.addToTail(new Employee("Adams", "Play", 22));

        list.printList();
        System.out.println();
        System.out.println(list.getSize());
        list.addBefore(new Employee("Adams", "Play", 94), joyJones);
        list.printList();
        System.out.println(list.size);

//        System.out.println(list.removeFromTail().toString());
//        System.out.println(list.size);
//        list.removeFromTail();
//        list.removeFromTail();
//        System.out.println(list.removeFromTail().toString());
//        System.out.println(list.size);

    }

}

class Queue{
    private Employee[] queue;
    private int front;
    private int back;

    public Queue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee){
        if (size() == queue.length - 1){
            int numOfItems = size();
            Employee[] newQueue = new Employee[2*queue.length];
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);
            System.arraycopy(queue, 0, newQueue, queue.length - front, back);
            queue = newQueue;

            front = 0;
            back = numOfItems;
        }
        queue[back] = employee;
        back++;
    }

    public Employee remove(){
        if(size() == 0){
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        front++;
        if(size() == 0){
            front =0;
            back = 0;
        }else if (front == queue.length){
            front = 0;
        }

        return employee;
    }

    public Employee peek(){
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size(){
        if (front <= back)
            return back - front;

        return back- front + queue.length;
    }

    public void printQueue(){
        for (int i = front; i <= back; i++){
            System.out.println(queue[i]);
        }
    }
}

class SorrtingArray{

    public static void main(String[] args){
        Integer[] arr = {3,1,2};

        System.out.println(sortElemnt(arr));
    }

    public static int sortElemnt(Integer[] arr){

        Integer count = 0;

        for (int i = 0; i < arr.length; i++){
            if ((i + 1) != arr[i]){
                swapElement(arr, arr[i], i);
                count++;
            }
        }

        return count;
    }

    public static void swapElement(Integer[] arr, Integer element, Integer index){
        Integer value = arr[element - 1];

        arr[element - 1]= element;
        arr[index] = value;
    }
}

class StoredEmployee{
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}

class HashTable{
    private StoredEmployee[] hashTable;

    public HashTable() {
        this.hashTable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)){
            int stopIndex = hashedKey;
            if (hashedKey == hashTable.length - 1){
                hashedKey = 0;
            }else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        hashTable[hashedKey] = new StoredEmployee(key, employee);
    }

    public Employee get(String key){
        int hashedKey = findKey(key);

        if (hashedKey == -1){
            return null;
        }

        return hashTable[hashedKey].employee;
    }

    private int findKey (String key){
        int hashedKey = hashKey(key);

        if (hashTable[hashedKey].key != null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1){
            hashedKey = 0;
        }else{
            hashedKey++;
        }

        while (hashTable[hashedKey].employee != null && !hashTable[hashedKey].key.equals(key)
                && hashedKey != stopIndex){
            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }else{
            hashedKey = -1;
        }

        return hashedKey;
    }

    public Employee remove(String key){
        int hashedKey = findKey(key);

        if (hashedKey == -1){
            return null;
        }

        Employee employee = hashTable[hashedKey].employee;

        hashTable[hashedKey].key = null;

        StoredEmployee[] oldStoredEmployee = hashTable;
        hashTable = new StoredEmployee[hashTable.length];
        for (int i = 0; i < hashTable.length; i++){
            if (oldStoredEmployee[i] != null)
                put(oldStoredEmployee[i].key, oldStoredEmployee[i].employee);
        }

        return employee;
    }

    public int hashKey(String key){
        return key.length() % hashTable.length;
    }

    public boolean occupied(int hashKey){
        return hashTable[hashKey].employee != null;
    }
}

class HashTableUsingChaining{
    private LinkedList[] hashTable;

    public HashTableUsingChaining() {
        hashTable = new LinkedList[10];
        Arrays.fill(hashTable, new LinkedList<>());
    }

    public static void removeDuplicate(){
        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        HashMap<Integer, Employee> map = new HashMap<>();

        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> removedEmp = new ArrayList<>();
        List<Integer> removedIndex = new ArrayList<>();

        while (iterator.hasNext()){
            Employee employee = iterator.next();

            if(map.containsKey(employee.getId())){
                removedEmp.add(employee);
                removedIndex.add(employees.indexOf(employee));
            }else{
                map.put(employee.getId(), employee);
            }
        }

        for (Integer employee: removedIndex){
            employees.remove(employee);
        }

        employees.forEach(System.out::println);
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);

        hashTable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();

        StoredEmployee employee = null;
        while ( iterator.hasNext()){
            employee = iterator.next();
            if (employee.key.equals(key)){
                return employee.employee;
            }
        }

        return employee.employee;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();

        StoredEmployee employee = null;
        int index = -1;
        while ( iterator.hasNext()){
            employee = iterator.next();
            index++;
            if (employee.key.equals(key)){
                break;
            }
        }

        if (employee == null || !employee.key.equals(key)){
            return null;
        }else{
            hashTable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    private int hashKey(String key){
        //this is a better way to hash a key, the modulus is to ensure
        // that you are always getting a value that is within the array
        //array length.
        Math.abs(key.hashCode() % hashTable.length);
        return key.length() % hashTable.length;
    }

    public void printHashTable(){
        for (int i = 0; i < hashTable.length; i++){
            if(hashTable[i].isEmpty()){
                System.out.println(String.format("No Object at position %d", i));
            }else{
                ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();

                StoredEmployee employee = null;
                while ( iterator.hasNext()){
                    employee = iterator.next();
                    System.out.println(String.format("%s Employee at Position %d", employee, i));
                }
            }
        }
    }
}

class BucketSort{
    public static void bucketSort(Integer[] arr){
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++ ){
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++){
            buckets[hash(arr[i])].add(arr[i]);
        }

        for (List bucket : buckets){
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++){
            List<Integer> bucket = buckets[i];
            for(Integer k : bucket){
                arr[j++] = k;
            }
        }

    }

    private static int hash(int key){
        return key / (int) 10 % 10;
    }
}

class Challenge{
    public static void main(String[] args){
        int[] nums = new int[10];

        int[] numToAdd = { 59382, 43, 6894, 500, 99, -58};

        for (int i = 0; i < numToAdd.length; i++){
            nums[hash(numToAdd[i])] = numToAdd[i];
        }

        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static int hash(int value){
        return Math.abs(value % 10);
    }
}

class Challenge2{
    public static void main(String[] args){

    }
}

class SearchAlgorithm{
    public static void main(String[] args){

    }

    public static void main(char[] args){

    }
    public static int linearSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == value)
                return i;
        }

        return -1;
    }

    public static int binarySearchAlgorithm(int[] arr, int value){
        int start = 0;
        int end = arr.length;

        while (start < end){
            int midpoint = (start + end)/2;

            if (arr[midpoint] == value){
                return midpoint;
            }else if (arr[midpoint] < value ){
                start = midpoint + 1;
            }else {
                end = midpoint;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearchAlgorithm(int[] arr, int value){
        return recursiveSearch(arr, 0, arr.length, value);
    }

    public static int recursiveSearch(int[] arr, int start, int end, int value){
        if (start >= end){
            return -1;
        }

        int midpoint = (start + end)/2;

        if (arr[midpoint] == value){
            return midpoint;
        }else if (arr[midpoint] < value ){
            recursiveSearch(arr, midpoint + 1, end, value);
        }else {
            recursiveSearch(arr, start, midpoint, value);
        }

        return -1;
    }
}

class BinaryTreeNode{
    private int data;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public void insert(int value){
        if (value == data){
            return;
        }

        if (value < data){
            if (leftNode == null){
                leftNode = new BinaryTreeNode(value);
            }else{
                leftNode.insert(value);
            }
        }else{
            if (rightNode == null){
                rightNode = new BinaryTreeNode(value);
            }else{
                rightNode.insert(value);
            }
        }
    }

    private BinaryTreeNode get(int value){
        if (value == data)
            return this;

        if (value < data){
            if(leftNode != null){
                return leftNode.get(value);
            }
        }else{
            if (rightNode != null){
                return rightNode.get(value);
            }
        }
        return null;
    }

    public int max(){
        if (rightNode!= null){
            return rightNode.max();
        }
        System.out.println("Max = "+ data);
        return data;
    }

    public int min(){
        if (leftNode != null){
            return leftNode.min();
        }
        System.out.println(data);
        return data;
    }

    public void traversalInOrder(){
        if (leftNode != null){
            leftNode.traversalInOrder();
        }
        System.out.print("Data = " + data);
        if (rightNode != null){
            rightNode.traversalInOrder();
        }
//        System.out.print("Data = " + data);
    }

    public void traversalPreOrder(){
        System.out.println(data + ", ");

        if (leftNode != null){
            leftNode.traversalPreOrder();
        }

        if(rightNode != null){
            rightNode.traversalPreOrder();
        }
    }

    public void traversalPostOrder(){
        if (leftNode != null){
            leftNode.traversalPreOrder();
        }

        if(rightNode != null){
            rightNode.traversalPreOrder();
        }

        System.out.println(data + ", ");
    }

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}

class Tree{
    private BinaryTreeNode tree;

    public void insert(int data){
        if (tree == null){
            tree = new BinaryTreeNode(data);
        }else{
            tree.insert(data);
        }
    }

    public void traverseInOrder(){
        if (tree == null){
            return;
        }else{
            tree.traversalInOrder();
        }
    }

    public void traversePreOrder(){
        if (tree == null)
            return;

        tree.traversalPreOrder();
    }

    public void traversePostOrder(){
        if (tree == null)
            return;

        tree.traversalPostOrder();
    }

    public void min(){
        if(tree == null)
            return;

        System.out.println(tree.min());
    }

    public void max(){
        if(tree == null)
            return;

        System.out.println(tree.max());
    }

    public void delete(int value){
        tree = delete(tree, value);
    }

    private BinaryTreeNode delete(BinaryTreeNode subTree, int value){
        if (subTree == null){
            return subTree;
        }

        if (value < subTree.getData()){
            subTree.setLeftNode(delete(subTree.getLeftNode(), value));
        }else if (value > subTree.getData()){
            subTree.setRightNode(delete(subTree.getRightNode(), value));
        }else{
            if (subTree.getLeftNode() == null){
                return subTree.getRightNode();
            }else if(subTree.getRightNode() == null){
                return subTree.getLeftNode();
            }

            subTree.setData(subTree.getRightNode().min());

            subTree.setRightNode(delete(subTree.getRightNode(), subTree.getData()));
        }
        return null;
    }


}




