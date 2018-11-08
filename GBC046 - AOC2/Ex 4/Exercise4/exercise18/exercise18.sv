module exercise18(
		input logic [3:0] SW,
		output logic [7:7] LEDG
);

assign  LEDG[7] = (SW[2] & SW[0]) | (SW[3] & (~SW[0])) | (SW[3] & SW[1]);

endmodule
