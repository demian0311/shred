#!/bin/sh

POST_BODY='{"duration": 23}'
HOST='http://localhost:9000/timer/com/twcable/cst/core/client/soa'

curl -k \
   --connect-timeout 60 \
   --verbose \
   --show-error \
   -X POST -d "$POST_BODY" \
   --header "content-type: application/json" \
   "$HOST"
