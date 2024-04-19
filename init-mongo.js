db.createUser({
    user: 'arkanoid_app',
    pwd: 'arkanoid_app',
    roles: [
        {
            role: 'readWrite',
            db: 'arkanoid',
        },
    ],
});