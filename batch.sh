for key in SLACK_WEBHOOK_URL MYSQL_HOST MYSQL_PORT MYSQL_DB MYSQL_USER MYSQL_PASSWORD MYSQL_MYBATIS_URL
do
value=`sudo -u ec2-user aws ssm get-parameters --name $key --query "Parameters[*].{Value: Value}" --output text`
export $key=$value
done

if [ $1 = "updateAtcoderUser" ]; then
  export BATCH_PORT=9000
fi

java -Xms1024m -Xmx1024m -jar /home/ec2-user/ningenme-net-batch/target/ningenme-net-batch.jar $1
curl -X POST --data-urlencode "payload={\"text\":\"succeeded $1 process\",\"channel\":\"#log-info\",}" $SLACK_WEBHOOK_URL