module exercise13(
		input logic [1:0] SW,
		output logic [7:4] LEDG
);

assign LEDG[7] = SW[1] & SW[0];
assign LEDG[6] = SW[1] & (~SW[0]);
assign LEDG[5] = (~SW[1]) & SW[0];
assign LEDG[4] = (~SW[1]) & (~SW[0]);
endmodule
		