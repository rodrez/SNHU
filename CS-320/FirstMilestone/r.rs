use argon2::{
    password_hash::{rand_core::OsRng, PasswordHasher, SaltString},
    Argon2,
};
use std::{env, ffi::OsStr};
pub fn hash_pass(pass: String) -> Option<String> {
    let hasher = Argon2::default();
    let secret_key = env::var("SECRET_KEY").expect("SECRET_KEY must be set in .env");
    log::info!(
        "Salt bytes: {:?}, salt length: {:?}",
        secret_key.as_bytes(),
        secret_key.as_bytes().len()
    );
    let salt =
        SaltString::b64_encode(&secret_key.as_bytes()).expect("Unable to create salt string.");
    log::info!("Salt bytes: {:?}, salt length: {:?}", salt, salt.len());
    match hasher.hash_password(pass.as_bytes(), &salt) {
        Ok(hashed_pass) => {
            let hashed_pass_result = hashed_pass.to_string();
            log::info!(
                "Created new argon2 password: {:?} and original pass is {:?}",
                hashed_pass_result,
                pass
            );
            return Some(hashed_pass_result);
        }
        Err(error) => {
            log::error!("Error when creating new argon2 password: {:?} ", error);
            return None;
        }
    }
    // 👆 returns a hash, which will be random since the default Hasher uses a random salt
}