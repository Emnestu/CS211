    public static double[] solve(double[][] contents){
        //fill this in
        //return a solution array with one negative weight indicating your selected stock and positive weights making up your portfolio
        int chosen = 256;
        int stocks = contents[0].length;
        int dates = contents.length;
        double[] solution = new double[stocks];
        solution[chosen]=-1;
        for(int i = 0; i < stocks; i++){
            for(int  j = 1; j < dates; j++) {
                if(i != chosen) { 
                    if((contents[j][i] < contents[j-1][i]) && (contents[j][chosen] < contents[j-1][chosen])) { //if both the looked at stock and the chosen stock went down
                        solution[i] += 1; //add more weight to the looked at stock
                    } else if ((contents[j][i] > contents[j-1][i]) && (contents[j][chosen] > contents[j-1][chosen])) { //if both the looked at stock and the chosen stock went up
                        solution[i] += 1; //add more weight to the looked at stock
                    } else { //the looked at stock and the chosen stock were asynchronous
                        solution[i] -= 1.5; //remove weight from the looked at stock
                    }    
                }
            }
        }
        //remove values under 0 from solution that are not the chosen stock
        for(int i = 0; i < stocks; i++) {
            if(i != chosen && solution[i] < 0) {
                solution[i] = 0;
            }
        }
        for(int i = 0; i < stocks; i++) {
            //System.out.print(solution[i] + ", ");
        }
        return solution;
    }
}
