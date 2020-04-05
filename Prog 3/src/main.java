import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        for (int i=0; i<1;i++) {
            runTest(false);
        }
    }

    private static void runTest(boolean printUnsorted) {
        int n;
        int a[];
/*
        n=6;
        a= new int[]{1, 6, 7, 2, 4, 8};
        System.out.println(Arrays.toString(a));
        ArraySorts.buildHeapBU(a,n);
        System.out.println(Arrays.toString(a));
        exit();*/
        Random r=new Random();
        boolean faster=true;
        n = 9999999;
        n = 100;
        n = 50;
        //n = 10;
        /*n = 5;*/
        a = new int[n];
        //int b[]=new int[]{13,0,9,20,11,22,11,5,25,21,17,18,3,11,1,23,22,10,20,13,5,7,10,10,18,19};
        //int b[]=new int[]{331, 528, 564, 17, 223};
        //int b[]=new int[]{170, 254, 402, 482, 500, 529, 633, 755, 829, 794};

        int b[]=new int[]{25,  1, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10,  9,  8,  7,  6,  5,  4,  3,  2, 24,  0};

        int insertion[] = new int[n];
        int heapBU[] = new int[n];
        int heapTD[] = new int[n];
        int quicksort1[] = new int[n];
        int almostquicksort1[] = new int[n];
        int quicksort2[] = new int[n];
        int quicksort3[] = new int[n];
        int quicksort4[] = new int[n];
        int quicksort5[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(999);
            //a[i] = b[i];
            insertion[i] = a[i];
            heapBU[i] = a[i];
            heapTD[i] = a[i];
            quicksort1[i]=a[i];
            almostquicksort1[i]=a[i];
            quicksort2[i]=a[i];
            quicksort3[i]=a[i];
            quicksort4[i]=a[i];
            quicksort5[i]=a[i];
           /* System.out.print(a[i]);
            System.out.print(",");*/
        }
        //a=new int[]{760,765,717,81,621,944,19,781,783,348,390,620,567,116,124,779,795,838,330,612,246,530,203,902,915,879,857,604,310,493,936,253,110,816,276,924,73,211,802,627,906,113,799,132,685,965,481,899,557,928,891,721,145,313,160,982,556,810,796,403,244,997,279,302,876,706,494,228,749,948,115,824,816,39,714,929,273,839,5,86,846,654,457,686,715,136,876,901,853,223,798,935,235,510,319,97,853,612,636,796,723,624,318,547,186,705,202,920,969,97,626,490,906,310,884,748,527,262,525,966,353,757,725,266,338,369,123,629,667,24,519,711,936,856,896,79,642,896,846,935,234,127,791,19,89,158,823,824,735,257,77,833,34,385,160,121,444,87,763,34,374,647,816,488,534,616,572,387,60,240,275,969,54,530,37,801,861,388,472,719,634,732,117,908,277,404,735,366,939,432,707,334,645,690,861,268,371,894,132,151,110,363,941,364,303,929,74,24,22,532,700,934,148,541,209,491,58,790,206,28,353,654,211,872,535,891,844,785,921,828,310,542,205,390,464,65,99,247,183,585,203,435,960,892,476,793,846,24,452,527,379,247,271,6,595,597,109,582,102,222,827,380,581,590,933,71,622,932,207,7,697,735,733,991,75,944,673,156,952,56,362,756,482,678,990,541,786,123,344,245,367,574,821,670,100,880,460,277,656,724,608,257,88,698,827,578,433,897,989,429,707,209,427,723,980,932,723,212,952,722,494,981,266,478,606,112,544,658,888,828,359,979,400,967,106,238,63,355,341,346,95,660,63,235,876,979,235,307,223,953,85,115,589,284,59,230,944,72,735,17,707,400,25,969,567,158,113,498,659,464,604,242,668,814,950,119,136,820,645,476,834,356,60,780,60,747,871,142,834,770,257,208,173,914,353,161,812,224,663,538,483,68,471,654,599,168,116,699,489,409,448,269,135,348,426,448,561,784,519,845,82,403,411,4,396,17,642,323,943,444,466,816,538,829,434,975,659,235,772,144,814,862,589,139,830,567,231,575,729,737,227,867,52,236,80,776,494,288,750,408,69,946,81,223,339,292,625,849,77,413,537,577,217,962,436,303,650,54,101,3,613,396,913,455,724,468,889,504,539,438,973,349,193,149,885,403,617,797,459,117,181,718,972,967,890,39,354,986,250,627,118,609,128,616,114,407,585,937,130,149,227,372,974,826,747,378,402,694,934,445,125,785,225,715,240,568,286,323,990,86,396,875,232,778,367,240,194,743,444,904,163,588,281,202,562,322,115,798,257,131,326,497,797,836,114,632,189,495,99,738,55,150,561,254,303,132,790,799,167,751,215,497,391,920,733,470,738,326,86,279,604,746,126,901,980,272,47,973,173,887,690,577,891,850,239,488,688,263,510,377,109,188,874,818,725,261,815,416,570,529,438,531,773,363,851,876,407,932,493,765,858,463,761,376,553,52,986,129,771,625,398,149,755,164,596,881,828,993,288,775,611,721,318,752,382,166,368,38,71,407,75,980,748,54,191,524,107,454,831,956,438,600,197,459,88,9,852,295,445,594,65,885,420,585,876,569,919,238,457,839,416,366,331,754,991,442,515,997,468,751,922,546,182,486,940,741,447,838,874,121,733,651,472,869,512,287,579,329,982,538,196,740,903,171,33,779,39,188,489,367,409,767,188,86,941,199,928,989,300,791,921,46,719,329,203,219,689,248,641,697,834,521,449,821,487,255,442,927,618,683,384,863,989,537,400,953,101,559,437,55,683,570,473,380,640,691,464,66,923,56,203,437,40,335,783,651,432,935,291,182,964,136,207,127,183,379,153,421,334,689,444,772,180,79,829,874,617,523,699,472,368,651,728,658,527,964,730,693,919,495,186,940,488,445,153,103,562,464,865,362,505,620,736,221,567,341,751,324,118,991,633,696,739,489,387,126,352,642,945,313,870,41,54,922,9,592,233,660,562,940,213,245,429,580,108,658,565,790,512,279,802,514,637,897,859,331,69,992,163,238,248,602,370,70,398,726,593,361,952,130,586,309,408,693,944,579,321,157,503,907,868,263,77,592,65,255,559,102,130,891,774,41,23,622,894,347,421,258,764,267,781,283,874,195,608,90,975,299,161,68,584,171,835,526,152,610,113,74,157,968,306,348,325,647,911,923,592,196,342,300,786,403,116,775,342,905,770,260,805,132,869,27,331,623,400,159,364,310,920,325,454,50,417,203,508,980,554,82,507,864,84,877,286,218,407,892,576,561,344,496,464,360,33,103,863,543,774,610,917,12};
        /*for(int i=0;i<n;i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }*/
        /*a=new int[]{};
        n=0;*/
        if(printUnsorted) {
            System.out.println("unsorted" + Arrays.toString(a));
        }
        long start;
        long finish;
        //System.out.println(Arrays.toString(heapBU));
        start = System.currentTimeMillis();
        ArraySorts.HeapSortBU(heapBU, n);
        finish = System.currentTimeMillis();
        long timeElapsed2 = finish - start;
        System.out.println("HeapSortBU took " + timeElapsed2);
           /* start = System.currentTimeMillis();
            ArraySorts.insertionSort(insertion, n);
            finish = System.currentTimeMillis();
            long timeElapsed1 = finish - start;
            System.out.println("insertionSort2 took " + timeElapsed1);*/
        start = System.currentTimeMillis();
        ArraySorts.QuickSort1(quicksort1, n,50);
        finish = System.currentTimeMillis();
        long timeElapsed3 = finish - start;
        System.out.println("QuickSort1 took " + timeElapsed3);
        start = System.currentTimeMillis();
        //int[] two ={0,1};
        ArraySorts.AlmostQS1(almostquicksort1, n,2);
        finish = System.currentTimeMillis();
        long almstimeElapsed3 = finish - start;
        System.out.println("AlmostQS1 took " + almstimeElapsed3);
        start = System.currentTimeMillis();
        ArraySorts.QuickSort2(quicksort2, n,50);
        finish = System.currentTimeMillis();
        long quicksort2timeElapsed = finish - start;
        System.out.println("QuickSor2 took " + quicksort2timeElapsed);
        start = System.currentTimeMillis();
        //ArraySorts.AlmostQS3(quicksort3, n,2);
        ArraySorts.QuickSort3(quicksort3, n,50);
        finish = System.currentTimeMillis();
        long QuickSort3timeElapsed = finish - start;
        System.out.println("QuickSort3 took " + QuickSort3timeElapsed);
        start = System.currentTimeMillis();
        ArraySorts.QuickSort4(quicksort4, n,50);
        finish = System.currentTimeMillis();
        long quicksort4timeElapsed = finish - start;
        System.out.println("QuickSort4 took " + quicksort4timeElapsed);

        start = System.currentTimeMillis();
        ArraySorts.QuickSort5(quicksort5, n,50);
        finish = System.currentTimeMillis();
        long QuickSort5timeElapsed = finish - start;
        System.out.println("QuickSort5 took " + QuickSort5timeElapsed);
        start = System.currentTimeMillis();
        ArraySorts.HeapSortTD(heapTD,n);
        finish = System.currentTimeMillis();
        long timeElapsedHeapSortTD = finish - start;
        System.out.println("HeapSortTD took " + timeElapsedHeapSortTD);

        System.out.println();
        System.out.println("done lets compare");
        System.out.println();
        start = System.currentTimeMillis();
        Arrays.sort(a);
        finish = System.currentTimeMillis();
        long timeElapsedjava = finish - start;
        System.out.println("java sort took " + timeElapsedjava);

        boolean sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=heapBU[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("heapBU sorted");
        }else{

            System.out.println("heapBU not sorted");
            System.out.println("heap sort "+Arrays.toString(heapBU));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }
       /* sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=insertion[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("insertion sorted");
        }else{
            System.out.println("insertion not sorted");
        }*/
        sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=quicksort1[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("quicksort1 sorted");
        }else{
            System.out.println("quicksort1 not sorted");
            System.out.println("quicksort1 sort "+Arrays.toString(quicksort1));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }
        sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=quicksort2[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("quicksort2 sorted");
        }else{
            System.out.println("quicksort2 not sorted");
            System.out.println("quicksort2 sort "+Arrays.toString(quicksort2));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }
        sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=quicksort3[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("quicksort3 sorted");
        }else{
            System.out.println("quicksort3 not sorted");
            System.out.println("quicksort3 sort "+Arrays.toString(quicksort3));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }
        sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=quicksort4[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("quicksort4 sorted");
        }else{
            System.out.println("quicksort4 not sorted");
            System.out.println("quicksort4 sort "+Arrays.toString(quicksort4));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }
        sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=quicksort5[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("quicksort5 sorted");
        }else{
            System.out.println("quicksort5 not sorted");
            System.out.println("quicksort5 sort "+Arrays.toString(quicksort5));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }

        sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=heapTD[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("heapTD sorted");
        }else{
            System.out.println("heapTD not sorted");
            System.out.println("heapTD sort "+Arrays.toString(heapTD));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }
        sorted=true;
        for(int i=0;i<n;i++) {
            if(a[i]!=almostquicksort1[i]){
                sorted=false;
            }
        }
        if (sorted){
            System.out.println("almostquicksort1 sorted");
        }else{
            System.out.println("almostquicksort1 not sorted");
            System.out.println("almostquicksort1 sort "+Arrays.toString(almostquicksort1));
            System.out.println("java sort "+Arrays.toString(a));
            System.out.println();
        }
        System.out.println();
        System.out.println("done");
        System.out.println();
    }

    private static void exit() {
        System.exit(0);
    }
}
