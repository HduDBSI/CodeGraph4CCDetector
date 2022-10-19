# CodeGraph4CCDetector

Source code for our paper "Graph-based Code Semantics Learning for Eﬃcient Semantic Code Clone Detection". We propose a Siamese graph-matching network based on attention mechanisms for CFGs/PDGs, which can capture key information at the token, statement, and graph levels to suﬃciently learn code semantics. With the following steps you can run it, also, you can view the code for our data preprocessing via the link mentioned below.

Step1: Execute the following command to install dependencies.

	pip install -r requriements.txt


Step2: Run main.py for training. The trained model will be saved in the saveModel folder.

	python main.py


Srep3: Run main_test_fast.py for parallel semantic clone detection. It loads the model from the saveModel folder to detect semantic clones. Note that the batch_size in the detection phase can be set large enough if the graphics card allows to speed up the detection efficiency. 

	python main_test_fast.py


Note that we also provide the data preprocessing source code TinyPDG-DataPreprocessingVersion, see https://github.com/QuanixnYang/TinyPDG-DataPreprocessingVersion. You can refer to it if you want to use TinyPDG to make your own dataset.
