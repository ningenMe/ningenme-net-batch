# pid=`jps | awk -F: '/ningenme-net-batch.jar/{print $1}' | awk '{print $1}'`
# if [ $pid != "" ] ; then
#     kill -9 $pid
# fi

./mvnw clean
./mvnw package

for key in SLACK_WEBHOOK_URL MYSQL_HOST MYSQL_PORT MYSQL_DB MYSQL_USER MYSQL_PASSWORD MYSQL_MYBATIS_URL
do
value=`sudo -u ec2-user aws ssm get-parameters --name $key --query "Parameters[*].{Value: Value}" --output text`
export $key=$value
done

sudo cp cron.txt /var/spool/cron/ec2-user

# java -jar target/ningenme-net-batch.jar &
# curl -X POST --data-urlencode "payload={\"text\":\"succeeded batch deploy\",\"channel\":\"#log-info\",}" $SLACK_WEBHOOK_URL