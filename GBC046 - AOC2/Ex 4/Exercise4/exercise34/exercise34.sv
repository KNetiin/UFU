module exercise34
(
		input  logic [3:0] SW, 
      output logic [7:4] LEDG
);
/*			clk = SW[3]
				reset  = SW[2]
				ta = SW[1] 
				tb = SW[0]
				la = LEDG[7:6]
				lb = LEDG[5:4] */
				
  logic [2:0] state, nextstate;
  parameter S0 = 3'b000;
  parameter S1 = 3'b001;
  parameter S2 = 3'b010;
  parameter S3 = 3'b011;
  parameter S4 = 3'b100;
  parameter S5 = 3'b101;
  parameter green  = 2'b00;
  parameter yellow = 2'b01;
  parameter red    = 2'b10;
  // State Register
  always @(posedge SW[3], posedge SW[2])
    if (SW[2]) state <= S0;
    else       state <= nextstate;
  // Next State Logic
  always @(*)
    case (state)
      S0: if (SW[1]) 	nextstate = S0;
				else   				nextstate = S1;
      S1:				         nextstate = S2;
      S2:         				nextstate = S3;
      S3: if (SW[2]) 	nextstate = S3;
				else 			   nextstate = S4;
      S4:        					nextstate = S5;
      S5:         				nextstate = S0;
    endcase
  // Output Logic
  always @ (*)
    case (state)
      S0: LEDG[7:4] = {green, red};
      S1: LEDG[7:4] = {yellow, red};
      S2: LEDG[7:4] = {red, red};
      S3: LEDG[7:4] = {red, green};
      S4: LEDG[7:4] = {red, yellow};
      S5: LEDG[7:4] = {red, red};
    endcase
endmodule