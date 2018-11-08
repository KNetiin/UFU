module exercise40(
		input logic [2:0] SW, 
      output logic [7:6]LEDG
);
/* 			clk = SW[2] 
				reset = SW[1]
				a = SW[0] 
				x = LEDG[7]
				y = LEDG[6]*/
  logic [3:0] state, nextstate;
  parameter S0  = 4'b0000;
  parameter S1  = 4'b0001;
  parameter S2  = 4'b0010;
  parameter S3  = 4'b0100;
  parameter S11 = 4'b0001;
  parameter S12 = 4'b0010;
  parameter S13 = 4'b0100;
  parameter S22 = 4'b1010;
  parameter S23 = 4'b1100;
  // State Register
  always @ (posedge SW[2], posedge SW[1])
    if (SW[1]) 	state <= S0;
    else       		state <= nextstate;
  // Next State Logic
  always @ (*)
    case (state)
      S0:  	if (SW[0])	nextstate = S11;	//
					else			 		nextstate = S0; 	//
      S1:  	if (SW[0])	nextstate = S12; //
				   else   				nextstate = S1;		//
      S2:  	if (SW[0])	nextstate = S13;	//
					else   				nextstate = S2; 	//
      S3:  	if (SW[0])	nextstate = S13;	//
					else   				nextstate = S3;		//
      S11: if (SW[0])	nextstate = S22;	//
					else   				nextstate = S1;		//
      S12: if (SW[0])	nextstate = S23; //
					else   				nextstate = S2;		//	
      S13: if (SW[0])	nextstate = S23;	//
					else   				nextstate = S3;		//		
      S22: if (SW[0])	nextstate = S23;	//
					else   				nextstate = S22;	//
      S23:  							nextstate = S23;	//
      default:    nextstate = S0;
    endcase
  // Output Logic
  assign LEDG[7:6] = {state[2],state[3]};
endmodule