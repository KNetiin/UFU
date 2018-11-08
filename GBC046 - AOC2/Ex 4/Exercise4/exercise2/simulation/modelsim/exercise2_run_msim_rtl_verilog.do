transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -sv -work work +incdir+/home/netiin/AOC2/Quartus/Exercise4/exercise2 {/home/netiin/AOC2/Quartus/Exercise4/exercise2/exercise2.sv}

