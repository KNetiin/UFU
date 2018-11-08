module exercise16(
		input  logic [4:0] SW,
      output logic [7:7] LEDG
);
	assign LEDG[7] = (SW[4] & SW[3]) | (SW[2] & SW[1]) | (~SW[0]);
endmodule