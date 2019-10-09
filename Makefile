run_all_in_parallel:
	make clean_it test_parallel

clean_it:
	mvn clean

test_parallel:
	make -j test_firefox test_ie test_chrome

test_firefox:
	mvn install -Dbrowser=firefox -Dbrowser_version=69.0 -Dos=Windows -Dos_version=7 -Dresolution=1024x768

test_ie:
	mvn install -Dbrowser=IE -Dbrowser_version=11.0 -Dos=Windows -Dos_version=10 -Dresolution=1024x768

test_chrome:
	mvn install -Dbrowser=chrome -Dbrowser_version=77.0 -Dos=Windows -Dos_version=10 -Dresolution=1024x768
