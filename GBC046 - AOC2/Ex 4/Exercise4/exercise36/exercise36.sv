module exercise36(
		input  logic [4:0] SW,
      output logic [3:0] LEDG
);
/*			clk = SW[4]
				reset = SW[3]
				n = SW[2] 
				d = SW[1]
				q = SW[0]
				dispense = LEDG[3]
				return5 = LEDG[2]
				return10 = LEDG[1]
				return2_10 = LEDG[0] */
  logic [3:0] state, nextstate;
  parameter S0 =  4'b0000;
  parameter S5 =  4'b0001;
  parameter S10 = 4'b0010;
  parameter S25 = 4'b0011;
  parameter S30 = 4'b0100;
  parameter S15 = 4'b0101;
  parameter S20 = 4'b0110;
  parameter S35 = 4'b0111;
  parameter S40 = 4'b1000;
  parameter S45 = 4'b1001;
  // State Register
  always @(posedge SW[4], posedge SW[3])
    if (SW[3]) state <= S0;
    else       	state <= nextstate;
  // Next State Logic
  always @ (*)
    case (state)
      S0:        if (SW[2]) nextstate = S5;
           else if (SW[1]) nextstate = S10;
           else if (SW[0]) nextstate = S25;
           else        				nextstate = S0;
      S5:        if (SW[2]) nextstate = S10;
           else if (SW[1]) nextstate = S15;
           else if (SW[0]) nextstate = S30;
           else        				nextstate = S5;
      S10:      if (SW[2]) nextstate = S15;
           else if (SW[1]) nextstate = S20;
           else if (SW[0]) nextstate = S35;
           else      					nextstate = S10;
      S25:          				   nextstate = S0;
      S30:           					nextstate = S0;
      S15:      if (SW[2]) nextstate = S20;
           else if (SW[1]) nextstate = S25;
           else if (SW[0]) nextstate = S40;
           else       					nextstate = S15;
      S20:      if (SW[2]) nextstate = S25;
           else if (SW[1]) nextstate = S30;
           else if (SW[0]) nextstate = S45;
           else        				nextstate = S20;
      S35:            					nextstate = S0;
      S40:             				nextstate = S0;
      S45:             				nextstate = S0;
      default:         			nextstate = S0;
    endcase
	   // Output Logic
  assign dispense   = (state == S25) | 
                      (state == S30) | 
                      (state == S35) | 
                      (state == S40) |
                      (state == S45);
  assign return5    = (state == S30) | 
                      (state == S40);
  assign return10   = (state == S35) | 
                      (state == S40);
  assign return2_10 = (state == S45);
endmodule