#!/bin/sh

docker rmi ibelan_release_band_test-backend
# docker rmi ibelan_release_band_test-frontend
docker rmi ibelan_release_band_test-backend_build
# docker rmi ibelan_release_band_test-frontend_build

# docker volume rm ibelan_release_band_test_frontend_build_volume
docker volume rm ibelan_release_band_test_backend_build_volume
docker volume rm ibelan_release_band_test_mongo_volume

docker volume rm $(docker volume ls -q)