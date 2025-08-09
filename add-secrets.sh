# Check if repo name is provided
if [ -z "$1" ]; then
  echo "❌ Usage: $0 <repo-name>"
  exit 1
fi

# Variables
ORG="Event-Based-Banking-Application"
REPO="$1"

# Replace these with actual secret values or read from env
SONAR_TOKEN={ sonar-token } # Generate the Sonar token and add it here
SONAR_PROJECT_KEY={ project_key } # Create project under the Event-Based-Banking-Application and add its project key
SONAR_ORG={ sonar-org } # Create a organization in sonar cloud and add it's key here

echo "🔧 Setting secrets for $REPO..."

gh secret set SONAR_TOKEN --repo "$ORG/$REPO" --body "$SONAR_TOKEN"
gh secret set SONAR_PROJECT_KEY --repo "$ORG/$REPO" --body "$SONAR_PROJECT_KEY"
gh secret set SONAR_ORG --repo "$ORG/$REPO" --body "$SONAR_ORG"

echo "✅ Secrets set for $REPO"
