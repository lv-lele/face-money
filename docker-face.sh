docker --version

cd /root/face-money

docker build -t face:v1 .

cid=$(docker ps -a| grep "face-1.0" | awk '{print $1}')

if [ "$cid" != "" ]; then

	docker rm -f $cid

fi

docker run -d --net=host -p 9999:9999 --privileged=true -v /root/face-money/images:/images --name face-1.0 face:v1