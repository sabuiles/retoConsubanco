function fn() {
  config = {
    urlBase: 'https://canales-tradicionales-ext-qa.apps.ambientesbc.com',
  };

  karate.configure('headers', {'Content-Type':'application/json'})
  karate.configure('ssl', true)
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  return config;
}