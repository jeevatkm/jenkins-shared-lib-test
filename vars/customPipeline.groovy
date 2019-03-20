
@Grab('org.apache.commons:commons-lang3:3.8.1')
// @Grab('software.amazon.awssdk:cloudformation:2.5.11')
@Grab('com.amazonaws:aws-java-sdk:1.11.205')

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.mutable.MutableObject

// import software.amazon.awssdk.regions.Region
// import software.amazon.awssdk.cloudformation.CloudFormationClient

import com.amazonaws.AmazonClientException
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.regions.Regions
import com.amazonaws.services.cloudformation.AmazonCloudFormation
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder

def call(Map pipeParams) {
    println 'customPipeline called successfully'

    println StringUtils.isAllUpperCase("ABC")

    def mutableObject = new MutableObject("Initial value");
    println mutableObject

    // def client = CloudFormationClient.bulider().region(Region.of('us-west-1')).build()
    // println client

    ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
    }

    AmazonCloudFormation stackbuilder = AmazonCloudFormationClientBuilder.standard()
            .withCredentials(credentialsProvider)
            .withRegion(Regions.US_WEST_2)
            .build();

    println stackbuilder
}