module exercise32(
		input   [3:0] SW,
      output [7:8] LEDG
);
/*			clk = SW[3]
				reset = SW[2]
				a = SW[1]
				b = SW[0] */
  logic [1:0] state, nextstate;
  parameter S0 = 2'b00;
  parameter S1 = 2'b01;
  parameter S2 = 2'b10;
  // State Register
  always @(posedge SW[3], posedge SW[2])
    if (SW[2]) state <= S0;
    else       	state <= nextstate;
  // Next State Logic
  always @ (*)
    case (state)
      S0: if (SW[1]) 	nextstate = S1;
          else   				nextstate = S0;
      S1: if (SW[0])	nextstate = S2;
          else   				nextstate = S0;
      S2:        					nextstate = S0;
      default:   			nextstate = S0;
    endcase
  // Output Logic
  assign LEDG = state[1];
endmodule