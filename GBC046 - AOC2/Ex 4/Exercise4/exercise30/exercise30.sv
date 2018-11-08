module exercise30
(
		input logic [5:0] SW,
      output logic [7:4]  LEDG
);
/* 			clk = SW[5] 
				reset = SW[4]
				p = SW[3]
				r = SW[2] 
				ta = SW[1]
				tb = SW[0]
				la = LEDG[7:6]
				lb = LEDG[5:4] */
	logic m;
	mode modefsm(SW[5:2], m);
	lights lightsfsm({SW[5:4],SW[1:0], m}, LEDG[7:4]);
endmodule

module mode(
		input logic [3:0] SW, 
      output logic [7:7] LEDG
);
/*		clk = SW[3]
			reset = SW[2]
			p = SW[1]
			r = SW[0]  */
			
  logic state, nextstate;
  parameter S0 = 1'b0;
  parameter S1 = 1'b1;
  
  // State Register
  always @(posedge SW[3], posedge SW[2])
    if (SW[2]) 	state <= S0;
    else 				state <= nextstate;
  
  // Next State Logic
  always @ (*)
    case (state)
      S0: if (SW[1]) 	nextstate = S1;
          else   				nextstate = S0;
      S1: if (SW[0]) 	nextstate = S0;
          else  					nextstate = S1;
    endcase
  // Output Logic
  assign LEDG[7] = state;
endmodule

module lights(
		input logic [4:0] SW,
      output logic [7:4] LEDG
);
/*			clk = SW[4]
				reset = SW[3]
				ta = SW[2]
				tb = SW[1]
				m = SW[0]
				la = LEDG[7:6]
				lb = LEDG[5:4]	*/
  logic  [1:0] state, nextstate;
  parameter S0 = 2'b00;
  parameter S1 = 2'b01;
  parameter S2 = 2'b10;
  parameter S3 = 2'b11;
  parameter green  = 2'b00;
  parameter yellow = 2'b01;
  parameter red    = 2'b10;
  // State Register
  always @(posedge SW[4], posedge SW[3])
    if (SW[3]) 	state <= S0;
    else     			state <= nextstate;
  // Next State Logic
  always @(*)
    case (state)
      S0: if (SW[2])    				 	nextstate = S0;
				else   			  				  		nextstate = S1;
      S1:           				 					nextstate = S2;
      S2: if (SW[1] | SW[0]) 	nextstate = S2;
				else        							nextstate = S3;
      S3:            								nextstate = S0;
    endcase
  // Output Logic
  always @ (*)
    case (state)
      S0: LEDG[7:4] = {green, red};
      S1: LEDG[7:4] = {yellow, red};
      S2: LEDG[7:4] = {red, green};
      S3: LEDG[7:4] = {red, yellow};
    endcase
endmodule