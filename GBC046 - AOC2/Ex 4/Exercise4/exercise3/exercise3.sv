module exercise3 (
		input [3:0] SW,
		output	[7:7] LEDG
);

assign LEDG = ^SW;
endmodule