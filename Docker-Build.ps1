param ($Ver = $("latest"))


function build
{
    ($Tag = ("is1di/authserver:$Ver"))
        mvn clean install
        docker build -t $Tag .
        docker push $Tag
}
build