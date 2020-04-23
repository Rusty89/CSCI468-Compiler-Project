INPUTS=inputs/* #  
mkdir usertest # 
for i in $INPUTS # 
	do # 
		filename=${i%.*} # 
		name=${filename##*/} #  
		echo "Testing input file $i" #  
		output1="${name}code.out" # 
		output2="${name}resultCode.out" # 
		outtest="${name}.out" # 
		outtest_code="${name}resultCodeCorrect.out" # 
		./Micro $i > usertest/$output1 # 
		./tiny usertest/$output1 > usertest/$output2 # 
		./tiny outputs/$outtest > usertest/$outtest_code # 
		diff -B -b -s usertest/$output2 usertest/$outtest_code #  
	done # 
rm -r usertest # 
