module exercise24(
	input logic [3:0] SW, 
	output logic [7:7] LEDG
	);
/*	SW[3] = clk
		SW[2] = reset
		SW[1] = a
		SW[0] = b */
	
logic [1:0] state, nextstate;

parameter S0 = 2'b00;
parameter S1 = 2'b01;
parameter S2 = 2'b10;
parameter S3 = 2'b11;

always_ff @(posedge SW[3], posedge SW[2])
if (SW[3]) state <= S0;
else state <= nextstate;

always_comb
	case (state)
		S0: if (SW[1] ^ SW[0]) nextstate = S1;
				else nextstate = S0;
		S1: if (SW[1] & SW[0]) nextstate = S2;
				else nextstate = S0;
		S2: if (SW[1] | SW[0]) nextstate = S3;
				else nextstate = S0;
		S3: if (SW[1] | SW[0]) nextstate = S3;
				else nextstate = S0;
endcase
 
assign LEDG[7] = ((state == S1) | (state == S2));
endmodule